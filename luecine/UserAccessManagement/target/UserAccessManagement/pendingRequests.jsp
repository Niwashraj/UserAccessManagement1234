<!DOCTYPE html>
<html>
<head>
    <title>Pending Requests</title>
</head>
<body>
    <h2>Pending Access Requests</h2>
    <table>
        <tr>
            <th>Employee Name</th>
            <th>Software Name</th>
            <th>Access Type</th>
            <th>Reason</th>
            <th>Action</th>
        </tr>
        <!-- Populate dynamically with requests from the database -->
        <tr>
            <td>John Doe</td>
            <td>Software 1</td>
            <td>Read</td>
            <td>Need access for project</td>
            <td>
                <form action="approveRequest" method="post">
                    <input type="hidden" name="requestId" value="1">
                    <button type="submit" name="action" value="approve">Approve</button>
                    <button type="submit" name="action" value="reject">Reject</button>
                </form>
            </td>
        </tr>
    </table>
</body>
</html>
