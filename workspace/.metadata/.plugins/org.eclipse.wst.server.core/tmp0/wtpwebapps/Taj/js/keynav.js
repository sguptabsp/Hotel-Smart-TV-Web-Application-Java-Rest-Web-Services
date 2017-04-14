$.keynav = new Object();

$.fn.keynav = function(onClass, offClass) {
	//Initialization
	var kn = $.keynav;
	if (!kn.init) {
		kn.el = new Array();
		$(document).keydown(function(e) {
			var key = e.charCode ? e.charCode : e.keyCode ? e.keyCode : 0;
			switch (key) {
			case 37:
				$.keynav.goLeft();
				break;
			case 38:
				$.keynav.goUp();
				break;
			case 39:
				$.keynav.goRight();
				break;
			case 40:
				$.keynav.goDown();
				break;
			case 13:
				$.keynav.activate();
				
				break;
			}
		});
		kn.init = true;
	}

	return this.each(function() {
		$.keynav.reg(this, onClass, offClass);
	});
}
$.fn.keynav_sethover = function(onClass, offClass) {
	return this.each(function() {
		this.onClass = onClass;
		this.offClass = offClass;
	});
}

$.keynav.reset = function() {
	var kn = $.keynav;
	kn.el = new Array();
}

$.keynav.reg = function(e, onClass, offClass) {
	var kn = $.keynav;
	e.pos = $.keynav.getPos(e);
	e.onClass = onClass;
	e.offClass = offClass;
	e.onmouseover = function (e) { $.keynav.setActive(this); };
	kn.el.push(e);
	var firstelmnt = document.getElementById(1);
	$.keynav.setActive(firstelmnt);
}
$.keynav.setActive = function(e) {
	var kn = $.keynav;
	var cur = $.keynav.getCurrent();
	$(cur).trigger('blur');
	for ( var i = 0; i < kn.el.length; i++) {
		var tmp = kn.el[i];
		$(tmp).removeClass().addClass(tmp.offClass);
	}
	$(e).removeClass().addClass(e.onClass);
	$(e).trigger('focus');
	kn.currentEl = e;
}
$.keynav.getCurrent = function() {
	var kn = $.keynav;
	if (kn.currentEl) {
		var cur = kn.currentEl;
	} else {
		var cur = kn.el[0];
	}
	return cur;
}
$.keynav.quad = function(cur, fQuad) {
	var kn = $.keynav;
	var quad = Array();
	for (i = 0; i < kn.el.length; i++) {
		var el = kn.el[i];
		if (cur == el)
			continue;
		if (fQuad((cur.pos.cx - el.pos.cx), (cur.pos.cy - el.pos.cy)))
			quad.push(el);
	}
	return quad;
}
$.keynav.activateClosest = function(cur, quad) {
	var closest;
	var od = 1000000;
	var nd = 0;
	var found = false;
	for (i = 0; i < quad.length; i++) {
		var e = quad[i];
		nd = Math.sqrt(Math.pow(cur.pos.cx - e.pos.cx, 2)
				+ Math.pow(cur.pos.cy - e.pos.cy, 2));
		if (nd < od) {
			closest = e;
			od = nd;
			found = true;
		}
	}
	if (found)
		$.keynav.setActive(closest);
}
$.keynav.goLeft = function() {
	var cur = $.keynav.getCurrent();
	var quad = $.keynav.quad(cur, function(dx, dy) {
		if ((dy >= 0) && (Math.abs(dx) - dy) <= 0)
			return true;
		else
			return false;
	});
	$.keynav.activateClosest(cur, quad);
}
$.keynav.goRight = function() {
	var cur = $.keynav.getCurrent();
	var quad = $.keynav.quad(cur, function(dx, dy) {
		if ((dy <= 0) && (Math.abs(dx) + dy) <= 0)
			return true;
		else
			return false;
	});
	$.keynav.activateClosest(cur, quad);

}

$.keynav.goUp = function() {
	var cur = $.keynav.getCurrent();
	//alert("id"+cur.id);
	var curid = cur.id;
	var nextid = parseInt(curid) - 1;
	//alert("nextid"+nextid);
	if (nextid < 1) {
		nextid = 10;
	}
	//alert(""+nextid);
	var nxtelement = document.getElementById(nextid);

	$.keynav.setActive(nxtelement);
	/* var quad = $.keynav.quad(cur,function (dx,dy) {
	if((dx >= 0) && (Math.abs(dy) - dx) <= 0)
	return true;
	else
	return false;
	});
	$.keynav.activateClosest(cur,quad);*/

}
var cnt = 1;
$.keynav.goDown = function() {

	var cur = $.keynav.getCurrent();
	//alert(parseInt(cur.id));

	var nextid = parseInt(cur.id) + 1;
	if (nextid > 10) {
		nextid = 1;
	}
	var nextelement = document.getElementById(nextid);
	/* var quad = $.keynav.quad(cur,function (dx,dy) {

	if((dx <= 0) && (Math.abs(dy) + dx) <= 0)
	return true;
	else
	return false;
	});*/

	if (cnt == 1) {
		$.keynav.setActive(cur);
		cnt++;
	} else
		$.keynav.setActive(nextelement);

	//alert(cnt);
}

$.keynav.activate = function() {
	var kn = $.keynav;
	$(kn.currentEl).trigger('click');
	
	//alert("trigger click by enter key");
}

$.keynav.getPos = function(e) {
	var l = 0;
	var t = 0;
	while (e.offsetParent) {
		l += e.offsetLeft
				+ (e.currentStyle ? $.intval(e.currentStyle.borderLeftWidth)
						: 0);
		t += e.offsetTop
				+ (e.currentStyle ? $.intval(e.currentStyle.borderTopWidth) : 0);
		e = e.offsetParent;
	}
	l += e.offsetLeft
			+ (e.currentStyle ? $.intval(e.currentStyle.borderLeftWidth) : 0);
	t += e.offsetTop
			+ (e.currentStyle ? $.intval(e.currentStyle.borderTopWidth) : 0);
	var cx = Math.round(t);
	var cy = Math.round(l);
	return {
		x : l,
		y : t,
		cx : cx,
		cy : cy
	};
};

$.intval = function(v) {
	v = parseInt(v);
	return isNaN(v) ? 0 : v;
};
