

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add account</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="./assets/css/style.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="../assets/styles/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/styles/jquery-ui.structure.min.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/styles/jquery-ui.theme.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <h1 style="text-align: center">Book A Reservation</h1>
        <table style="margin-left: auto; margin-right: auto; border: 1px solid">
            <tr>
                <th>Action</th>
                <th>Ngày khám bệnh</th>
                <th>Yêu cầu của bệnh nhân</th>
                <th>Add</th>
            </tr>

            <form action="../BookReservationController" method="POST">
                <tr>
                    <td style="text-align: center; border: 1px solid" hidden>
                        <input value="<%= request.getParameter("serviceId")%>" name="serviceId">
                    </td>
                    <td style="text-align: center; border: 1px solid" hidden>
                        <input value="<%= request.getParameter("packageId")%>" name="packageId">
                    </td>
                    <td style="text-align: center; border: 1px solid">
                          <input type="radio" name="type" value="">
                          <label for="html">Chọn 1 ngày ưa thích</label><br>
                          <input type="radio"  name="type" value="">
                          <label for="css">Ngày sớm nhất có sẵn</label><br>
                    </td>
                    <td style="text-align: center; border: 1px solid">
                        <input name="date" type="date" required="Hãy nhập ngày khám bệnh">
                    </td>
                    <td style="text-align: center; border: 1px solid">
                        <input name="request" type="text">
                    </td>
                    <td style="text-align: center; border: 1px solid" class="btn-success">
                        <a href="">
                            <button type="submit" class="btn btn-primary">Add</button>
                        </a>
                    </td>
                </tr>
            </form>
        </table>
    </body>
</html>
