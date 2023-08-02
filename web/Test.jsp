<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       
        
        <!-- DataTables CSS -->
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.css">
        
        <!-- jQuery -->
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        
        <!-- DataTables JS -->
        <script type="text/javascript" src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.js"></script>
    </head>
    <body>
        <table id="dataTable">
            <!-- Your table headers will be generated dynamically by DataTables -->
        </table>
        
        <script type="text/javascript">
            // The JSON data provided
            const jsonData = '{"data":[["C","0107537001552","00000",""]]}';
            // Parse the JSON data into an array that DataTables can use
            const x = JSON.parse(jsonData);
            const data = x.data;

            // Create the DataTable
            $(document).ready(function() {
                const dataTable = $('#dataTable').DataTable({
                    data: data
                });

                // Add the button for CSV export
            });
        </script>
    </body>
</html>
