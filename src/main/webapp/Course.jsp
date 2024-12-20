<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="./ExtCss.css">
        <script src="./script.js"></script>    
      <style>
      .font{
      font-size:30px;
      color:green;
      }
      
      </style> 

    </head>
    
    
    	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3">
					<label class="font" >VCUBE</label>
			</div>
			<div class="col-sm-6">
				
			</div>
			<div class="col-sm-3">
			
				<h1 class="font1">Welcome <%= session.getAttribute("username") %></h1>
				
				
			</div>
		</div>
	</div>
    <body style="background-color:black;">
        <div class="container">
            <div class="row">
                <div class="col-sm-2"></div>
                <div class="col-sm-8 top">
                    <h4  style="text-align:center;color:green;">COURSES</h4>
                    <form class="form-group"  name="login" method="post" action="course"  onsubmit="return error()">
                        <div class="row">
                            <div class="col-sm-6">
                                <input  class="form-control" type="text" name="course" id="course" placeholder="*COURSE NAME" required>
                            </div>
                            <div class="col-sm-6">
                                <input class="form-control" type="text" name="fee" id="fee" placeholder="*FEES" required>
                                <p></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6">
                               
                                <select class="form-control" id="duration" name="duration" required>
                                    <option value=""selected>COURSE-DURATION (IN MONTHS)</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>

                                </select>
                            </div>
                            <div class="col-sm-6">
                                <input class="form-control" type="text" name="location" id="location" placeholder="*LOCATION" required>
                                <p></p>
                            </div>
                           
                        </div>
                            <div class="row">
                                <div class="col-sm-12">
                                    <button  type="submit" class=" form-control btn btn-success">LOGIN</button>
                                    <p id="p1"> </p>                        
                                </div>
                            </div>
                        
                    </form>
                </div>
                <div class="col-sm-2"></div>
            </div>
        </div>
        <script>


            document.getElementById("course").addEventListener("keypress",func1);
            document.getElementById("fee").addEventListener("keypress",func2);
            function func1(event){
                var chh=event.which
                if(!((chh>=65 && chh<=90) || (chh>=97 && chh<=122)||(chh==32))){
                event.preventDefault();
                }
            }

            function func2(event){
                var ch=event.which;
                if(!((ch>=48 &&ch<=57))){
                    event.preventDefault();
                }
                
            }
            
            function error(){

                var course=document.getElementById("course").value;
                var fee=document.getElementById("fee").value;
                var duration=document.getElementById("duration").value;
                var location=document.getElementById("location").value;
                
            
                

                if(course==""||fee==""||duration==""||location==""){

                    document.getElementById("p1").innerHTML="*ENTER ALL MANDATORY FIELDS";
                    document.getElementById("p1").style.color="red";

                    return false;
                }
                else{
                    return true;
                }
            }
        </script>
    </body>
</html>