<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<h1>Company Expense Reimbursement Manager</h1>

<form method= "get" action = "/Project1/login.do">

  <div class="container">
    <label for="email"><b>Email Address</b></label>
    <input type="text" placeholder="Enter Company email" name="email" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required><br>
    
  	<input type="radio" name="employeetype" value="employee" required> Employee<br>
  	<input type="radio" name="employeetype" value="manager"> Manager<br>



    <button type="submit" id ="loginbutton">Login</button>
  
  </div>
</form>
</body>
</html>