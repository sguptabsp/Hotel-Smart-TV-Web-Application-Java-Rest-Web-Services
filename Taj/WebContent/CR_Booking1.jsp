<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Conference Room Booking</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="description" content="Awesome Bubble Navigation with jQuery" />
        <meta name="keywords" content="jquery, circular menu, navigation, round, bubble"/>
        <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
        <style>
            *{
                margin:0;
                padding:0;
            }
            body{
                font-family:Arial;
                background:#fff url(images/bg.png) no-repeat top left;
            }
            
            
            #content{
                margin:0 auto;
            }


        </style>
       
    </head>

    <body>
    <form action="ConfRoomServlet" method="post">
    
    
    <h1 style="text-align:center;"><b>Conference Room Booking</b></h1>
        <div id="content">
            <a class="back" href="http://tympanus.net/codrops/2010/04/29/awesome-bubble-navigation-with-jquery"></a>
            <div class="title"></div>

            <div class="navigation" id="nav">
                <div class="item user">
                    <img src="images/bg_user.png" alt="" width="199" height="199" class="circle"/>
                    <a href="#" class="icon"></a>
                    <h2>Accessories</h2>
                    <ul>
                        <li>Keyboard<input type="checkbox" name="checkbox_group" value="keyboard"/></li>
                        <li>Mouse<input type="checkbox" name="checkbox_group" value="mouse" /></li>
                    </ul>
                </div>
                <div class="item home">
                    <img src="images/bg_home.png" alt="" width="199" height="199" class="circle"/>
                    <a href="#" class="icon"></a>
                    <h2>TV</h2>
                    <ul>
                        <li>Smart TV<input type="checkbox" name="checkbox_group" value="tv"/></li>
                    </ul>
                </div>
                <div class="item shop">
                    <img src="images/bg_shop.png" alt="" width="199" height="199" class="circle"/>
                    <a href="#" class="icon"></a>
                    <h2>Projector</h2>
                    <ul>
                        <li>Projector<input type="checkbox" name="checkbox_group" value="projector"/></li>
                    </ul>
                </div>
                <div class="item camera">
                    <img src="images/bg_camera.png" alt="" width="199" height="199" class="circle"/>
                    <a href="#" class="icon"></a>
                    <h2>Phone</h2>
                    <ul>
                        <li>Phone<input type="checkbox" name="checkbox_group" value="phone"/></li>
                    </ul>
                </div>
                <div class="item fav">
                    <img src="images/bg_fav.png" alt="" width="199" height="199" class="circle"/>
                    <a href="#" class="icon"></a>
                    <h2>Members</h2>
                    <ul>
                        <li>Max 20<input type="checkbox" name="checkbox_group" value="20"/></li>
                        <li>Max 35<input type="checkbox" name="checkbox_group" value="35"/></li>
                        <li>Max 50<input type="checkbox" name="checkbox_group" value="50 "/></li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- The JavaScript -->
        <script type="text/javascript" src="jquery.min.js"></script>
        <script type="text/javascript" src="jquery.easing.1.3.js"></script>
        <script type="text/javascript">
            $(function() {
                $('#nav > div').hover(
                function () {
                    var $this = $(this);
                    $this.find('img').stop().animate({
                        'width'     :'199px',
                        'height'    :'199px',
                        'top'       :'-25px',
                        'left'      :'-25px',
                        'opacity'   :'1.0'
                    },500,'easeOutBack',function(){
                        $(this).parent().find('ul').fadeIn(700);
                    });

                    $this.find('a:first,h2').addClass('active');
                },
                function () {
                    var $this = $(this);
                    $this.find('ul').fadeOut(500);
                    $this.find('img').stop().animate({
                        'width'     :'52px',
                        'height'    :'52px',
                        'top'       :'0px',
                        'left'      :'0px',
                        'opacity'   :'0.1'
                    },5000,'easeOutBack');

                    $this.find('a:first,h2').removeClass('active');
                }
            );
            });
        </script>
    <div style="margin: 400px 80px 270px 300px;">
    <h2>Select Your Requirements</h2><br></br><br></br>
    <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" style="width: 10em; background-color: #E0E0E0; font-size: 100%; font-weight:100em; color: #000000;">Check Availability</button></h3>
    </div>
    </form>
    </body>
</html>