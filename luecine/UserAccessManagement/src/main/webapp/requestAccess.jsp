<!DOCTYPE html>
<html>
<head>
    <title>Request Access</title>
</head>
<body>
    <h2>Request Access to Software</h2>
    <form action="requestAccess" method="post">
        Software Name:
        <select name="softwareId">
            <!-- Populate dynamically from database -->
            <option value="1">Software 1</option>
            <option value="2">Software 2</option>
        </select><br>
        Access Type:
        <select name="accessType">
            <option value="Read">Read</option>
            <option value="Write">Write</option>
            <option value="Admin">Admin</option>
        </select><br>
        Reason for Request: <textarea name="reason" required></textarea><br>
        <input type="submit" value="Request Access">
    </form>
</body>
</html>
