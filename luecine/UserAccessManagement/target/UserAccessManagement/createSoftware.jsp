<!DOCTYPE html>
<html>
<head>
    <title>Create Software</title>
</head>
<body>
    <h2>Create Software Application</h2>
    <form action="createSoftware" method="post">
        Software Name: <input type="text" name="softwareName" required><br>
        Description: <textarea name="description" required></textarea><br>
        Access Levels:<br>
        <input type="checkbox" name="accessLevels" value="Read"> Read<br>
        <input type="checkbox" name="accessLevels" value="Write"> Write<br>
        <input type="checkbox" name="accessLevels" value="Admin"> Admin<br>
        <input type="submit" value="Create Software">
    </form>
</body>
</html>
