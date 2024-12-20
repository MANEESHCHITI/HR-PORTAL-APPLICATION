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




    </head>
    <body style="background-color:black;">
       
            <div class="container  ">
                <div class="row ">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-8 top">
                        <h4 style="color:green; text-align:center;"> LOGIN  </h4>
                        <form class="form-group"  name="login" method="post" action="admin"  onsubmit="return valid1()">
                            <div class="row">
                                <div class="col-sm-12">                            
                                   <select  class="form-control" id="logintype" name="logintype">
                                    <option value=""selected>LOGIN-TYPE</option>
                                    <option value="admin">ADMIN</option>
                                    <option value="faculty">FACULTY</option>
                                    <option value="student">STUDENT</option>
                                    </select>
                                    <p></p>
                                </div>
                               
                            </div>
                            <div class="row">
                                <div class="col-sm-12">                            
                                    <input  class="form-control" type="text" name="username" id="username"placeholder="*USERNAME">
                                    <p></p>
                                </div>
                               
                            </div>
                            <div class="row">
                                <div class="col-sm-12">
                                
                                    <input class="form-control" type="text" name="password" id="password"placeholder="*Password">
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

                function valid1(){
    
                    var username=document.getElementById("username").value;
                    var password=document.getElementById("password").value;
                    if(username==""||password==""){
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