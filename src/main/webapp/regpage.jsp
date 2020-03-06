<!DOCTYPE html>
<html lang="en">
<head>
    <title>CRUD Register Page</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h4 class="w3-left-align"> Hibernate Version  |  Pred.Prod Task # 5 </h4>
    <!--    <h6></h6>-->
</div>

<div class="w3-container w3-center">

    <div class="w3-bar w3-padding-large w3-padding-24">

        <form class="w3-btn w3-hover-light-blue w3-round-large w3-xlarge" method="post" action="/rgstr">

            <input type="text" required placeholder="NAME" name="name"><br>

            <label>Sex:
                <select required name="sex">
                    <option value="male">MALE</option>
                    <option value="female">FEMALE</option>
                </select></label><br>

            <input type="number" min="1" max="150" required placeholder="AGE" name="age"><br><br>

            <input type="text" required placeholder="EMAIL" name="email"><br>

            <input type="text" required placeholder="SSN" name="ssn"><br><br>

            <label>Role:
                <select required name="role">
                    <option value="user">USER</option>
                    <option value="admin">ADMIN</option>
                </select></label><br><br><br>
            <input class="button" type="submit" value="SIGN UP">
        </form>

    </div>

    <div>
        <div class="w3-container w3-grey w3-opacity w3-center w3-padding">
            <button class="w3-btn w3-round-large w3-green" onclick="location.href='/'">Go to SIGN IN</button>
        </div>
    </div>

</div>

</body>
</html>