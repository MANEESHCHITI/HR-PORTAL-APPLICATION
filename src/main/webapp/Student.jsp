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
        font:size:30px;
        color:green;
        }
        </style>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3">
					<label class="font">VCUBE</label>
			</div>
			<div class="col-sm-6">
				
			</div>
			<div class="col-sm-3">
			
		<h1 class="font1">Welcome <%= session.getAttribute("username") %></h1>	
 		
		 	
					
				
			</div>
		</div>
	</div>

    </head>
    <body style="background-color:black;">
       
        <div class="container">
            <div class="row">
                <div class="col-sm-2"></div>
                <div class="col-sm-8 top">
                             <h4 style="text-align:center;color:green;">STUDENT REGISTRATION</h4>
                     <p></p>
                    <form   class="form-group" method="post" action="student" name="student" onsubmit="return error()">
                        <div class="row">
                            <div class="col-sm-6">
                                <input class="form-control" type="text" id="first_name" name="firstname" placeholder="*FIRST NAME">
                            </div>
                            <div class="col-sm-6">
                                <input class="form-control" onfocus="firstlast1()" onblur="firstlast()" type="text" id="last_name" name="lastname" placeholder="*LAST NAME">
                                <p id="fila"> </p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <select class="form-control" id="gender" name="gender">
                                    <option value=""selected>GENDER</option>
                                    <option value="male">MALE </option>
                                    <option value="female">FEMALE </option>
                                    <option value="others">OTHERS </option>
                                </select>
                                <p></p>

                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6">
                                <input class="form-control" type="text" id="mobile" maxlength="10" name="mobile" placeholder="*MOBILE">
                            </div>
                            <div class="col-sm-6">
                                <input class="form-control" type="email" id="gmail" name="gmail" placeholder="*GMAIL">
                                <p></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6">
                                <input class="form-control" type="text" id="year" name="year" placeholder="*PASSED OUT YEAR">
                            </div>
                            <div class="col-sm-6">
                                <input class="form-control" type="text" id="branch" name="branch" placeholder="*BRANCH">
                                <p></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6">
                                <!-- <input class="form-control" type="text" id="course" name="course"  placeholder="*BRANCH"> -->

                                <select class="form-control " name="course" id="course">
                                    <option value=""selected>COURSE</option>
                                    <option value="java">JAVA</option>
                                    <option value="python">PYTHON</option>
                                    <option value="dot net">DOT NET</option>
                                    <option value="aws">AWS</option>
                                    <option value="salesforce">SALESFORCE</option>
                                </select>
                            </div>
                            <div class="col-sm-6">
                                <input class="form-control" type="text" id="college" name="college" placeholder="*COLLEGE">
                                <p></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6">
                                <input class="form-control" type="text" id="username" name="username" placeholder="*USERNAME">
                            </div>
                            <div class="col-sm-6">
                                <input class="form-control" type="text" name="password" id="password" placeholder="*Password">
                                <p id="pwd"> </p>
                                <p></p>
                            </div>
                        </div>
                        <div class="row" >
                            <div class="col-sm-6">
                                <input class="form-control"  onfocus="verify1()" onblur="verify()" type="text" name="confirmpassword" id="confirmpassword" placeholder="*CONFIRM PASSWORD"> 
                                <p id="repswd"></p>
                            </div>

                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <button type="submit"  class=" form-control btn btn-success" >SUBMIT</button>
                               <p id="p1"></p>
                            </div>
                        </div>

                      
                    </form>
                </div>
                <div class="col-sm-2"></div>
            </div>
        </div>
        <script src="./script.js"></script>
               
        <script>

            document.getElementById("first_name").addEventListener("keypress",func1);
            document.getElementById("last_name").addEventListener("keypress",func1);
            document.getElementById("mobile").addEventListener("keypress",func2);
            document.getElementById("year").addEventListener("keypress",func2);
            document.getElementById("branch").addEventListener("keypress",func1);
            document.getElementById("college").addEventListener("keypress",func1);

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

            function verify1(){

                document.getElementById("repswd").innerHTML="";
            }
            function verify()
            {
                var pswd=document.getElementById("password").value;
                var repswd=document.getElementById("confirmpassword").value;

                if(pswd==repswd){
                    document.getElementById("repswd").innerHTML="";
                }
                else{
                    
                    document.getElementById("repswd").innerHTML="Confirm Password Mis-Matched";
                    document.getElementById("repswd").style.color="red";
                }
            }

            function firstlast(){

                var first_name=document.getElementById("first_name").value;
                var last_name=document.getElementById("last_name").value;
                if(first_name==last_name){
                    document.getElementById("fila").innerHTML="*FIRST AND LAST NAME SHOULD BE DIFFERENT";
                    document.getElementById("fila").style.color="red";
                    
                }
            }
            function firstlast1(){
                document.getElementById("fila").innerHTML="";
            }
        



                



            function error(){
                var first_name=document.getElementById("first_name").value;
                var last_name=document.getElementById("last_name").value;
                var mobile=document.getElementById("mobile").value;
                var gmail=document.getElementById("gmail").value;
                var year=document.getElementById("year").value;
                var branch=document.getElementById("branch").value;
                var course=document.getElementById("course").value;
                var college=document.getElementById("college").value;

                if(first_name==""||last_name==""||mobile==""||gmail==""||year==""||branch==""||course==""||college==""){

                    document.getElementById("p1").innerHTML="*ENTER ALL MANDATORY FIELDS";
                    document.getElementById("p1").style.color="red";

                    return false;
                }

                else if(first_name==last_name){
                    document.getElementById("fila").innerHTML="*FIRST AND LAST NAME SHOULD BE DIFFERENT";
                    document.getElementById("fila").style.color="red";
                    return false;
                }
                else if(!(pswd==repswd)){
                   return false;
                }

                else{
                    return true;
                }
            }

            
            
        </script>
    </body>
</html>