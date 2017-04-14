var matrix = new Matrix()

$(document).ready(function() {

})

function Matrix() {
    // whether or not keyboard nav is enabled
    this.enabled = true

    // columns in the matrix
    this.columns = new Array()

    // there are no columns yet, so active column is null
    this.active_column = null

    // add a column to the matric
    this.add_column = function(col) {
        this.columns.push(col)
        // if this is the first column added to the matrix, make it active
        if (this.columns.length == 1) {
            this.active_column = col
            $(col.elements[0]).trigger('focusin')
        }
    }

    // set a column at specific index
    this.set_column = function(idx, col) {
        this.columns[idx] = col
    }
    
    // delete a column at a specific index
    this.delete_column = function(idx) {
        this.columns[idx] = null
    }

    // scroll right
    this.scroll_right = function() {
        var active_idx = this.columns.indexOf(this.active_column)
        
        if (active_idx != this.columns.length-1) {
            // call any focus out listeners
            for (var i in this.active_column.focus_out_listeners) {
                var active_element = this.active_column.elements[this.active_column.active_element]
                this.active_column.focus_out_listeners[i](active_element)
            }

            var previous_col = this.active_column
            var previous_element = previous_col.active_element
            this.active_column = this.columns[active_idx+1]

            if (previous_col.inherit_active && this.active_column.inherit_active) {
                this.active_column.active_element = previous_element
            }
            
            // send focus events
            if (previous_col.focus_on_scroll) {
                $(previous_col.elements[previous_element]).trigger('focusout')
            }
            if (this.active_column.focus_on_scroll) {
                $(this.active_column.elements[this.active_column.active_element]).trigger('focusin')
            }
            
            // call any focus in listeners
            for (var i in this.active_column.focus_in_listeners) {
                var active_element = this.active_column.elements[this.active_column.active_element]
                this.active_column.focus_in_listeners[i](active_element)
            }
        }
    }

    // scroll left
    this.scroll_left = function() {
        var active_idx = this.columns.indexOf(this.active_column)

        if (active_idx > 0) {
            for (var i in this.active_column.focus_out_listeners) {
                var active_element = this.active_column.elements[this.active_column.active_element]
                this.active_column.focus_out_listeners[i](active_element)
            }

            var previous_col = this.active_column
            var previous_element = previous_col.active_element
            this.active_column = this.columns[active_idx-1]

            if (previous_col.inherit_active && this.active_column.inherit_active) {
                this.active_column.active_element = previous_element
            }

            // send focus events
            if (previous_col.focus_on_scroll) {
                $(previous_col.elements[previous_element]).trigger('focusout')
            }
            if (this.active_column.focus_on_scroll) {
                $(this.active_column.elements[this.active_column.active_element]).trigger('focusin')
            }

            // call any focus in listeners
            for (var i in this.active_column.focus_in_listeners) {
                var active_element = this.active_column.elements[this.active_column.active_element]
                this.active_column.focus_in_listeners[i](active_element)
            }
        }
    }

    // key-pressed event handler for page
    $(document).keydown(function(e) {
        if (matrix.enabled == true && matrix.active_column != null) {
            switch (e.keyCode) {
                case 37: // left arrow
                    matrix.scroll_left()
                    break
                case 38: // up arrow
                    matrix.active_column.scroll_up()
                    break
                case 39: // right arrow
                    matrix.scroll_right()
                    break
                case 40: // down arrow
                    matrix.active_column.scroll_down()
                    break
                case 13: // enter
                    matrix.active_column.enter_pressed()
                default:
                    break
            }
        }
    })
}

/*
 * A column in the arrow-key navigable matrix.
 * Parameters:
 *      elements: an Array of DOM elements that compose the column
 *      inherit_active (optional): Whether or not to inherit the previously selected column's active index when scrolling left / right
 *      focus_on_scroll (optional): Whether or not to trigger a focusin / focusout event when scrolling left / right
 */
function Column(elements, inherit_active, focus_on_scroll) {
    this.elements = elements
    this.inherit_active = inherit_active
    this.focus_on_scroll = focus_on_scroll
    this.active_element = 0
    this.focus_in_listeners = new Array()
    this.focus_out_listeners = new Array()

    // scroll down handler
    this.scroll_down = function() {
        // keep track of previously selected element
        var idx = this.active_element
        while (idx < this.elements.length-1) {
            // set focus on next visible element in column 
            var visible = $(this.elements[idx+1]).is(':visible')
            if (visible) {
                $(this.elements[this.active_element]).trigger('focusout')    
                $(this.elements[idx+1]).trigger('focusin')
                this.active_element = idx+1
                break
            } else {
                // elemenet is not visible, so skip it
                idx++
            }
        }
    }

    // scroll up handler
    this.scroll_up = function() {
        // keep track of previously selected element
        var idx = this.active_element
        while (idx > 0) {
            // set focus on next visible element in column
            var visible = $(this.elements[idx-1]).is(':visible')
            if (visible) {
                $(this.elements[this.active_element]).trigger('focusout')    
                $(this.elements[idx-1]).trigger('focusin')
                this.active_element = idx-1
                break
            } else {
                // elemenet is not visible, so skip it
                idx--
            }
        }
    }

    this.add_focus_in_listener = function(listener) {
        this.focus_in_listeners.push(listener)
    }
    
    this.add_focus_out_listener = function(listener) {
        this.focus_out_listeners.push(listener)
    }

    // 'enter' handler
    this.enter_pressed = function() {
        $(this.elements[this.active_element]).trigger('click')
    }

}

