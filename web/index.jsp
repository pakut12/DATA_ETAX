<%-- 
    Document   : index
    Created on : 21 ก.ค. 2566, 14:03:18
    Author     : pakutsing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <%@ include file="share/header.jsp" %>
    </head>
    <body>
        <div class="container">
            <div class="text-center h1 fw-bold mt-3">
                GET DATA ETAX
            </div>
            <div class="card mt-3 shadow" >
                <div class="card-header">
                    ค้นหา
                </div>
                <div class="card-body">
                    <div class="row ">
                        <div class="col-sm-12 col-md-6 mx-auto">
                            <div class="input-group input-group-sm mb-3">
                                <span class="input-group-text" id="inputGroup-sizing-sm">BUKRS</span>
                                <input type="text" class="form-control text-center" id="BUKRS" name="BUKRS">
                            </div>
                            <div class="input-group input-group-sm mb-3">
                                <span class="input-group-text" id="inputGroup-sizing-sm">LBLDAT</span>
                                <input type="date" class="form-control text-center" id="LBLDAT" name="LBLDAT">
                            </div>
                            <div class="input-group input-group-sm mb-3">
                                <span class="input-group-text" id="inputGroup-sizing-sm">HBLDAT</span>
                                <input type="date" class="form-control text-center" id="HBLDAT" name="HBLDAT">
                            </div>
                            <div class="input-group input-group-sm mb-3">
                                <span class="input-group-text" id="inputGroup-sizing-sm">LKUNRG</span>
                                <input type="text" class="form-control text-center" id="LKUNRG" name="LKUNRG">
                            </div>
                            <div class="input-group input-group-sm mb-3">
                                <span class="input-group-text" id="inputGroup-sizing-sm">HKUNRG</span>
                                <input type="text" class="form-control text-center" id="HKUNRG" name="HKUNRG" >
                            </div>
                            
                        </div>
                        <div class="col-sm-12 col-md-6 mx-auto">
                            <div class="input-group input-group-sm mb-3">
                                <span class="input-group-text" id="inputGroup-sizing-sm">LBRNCH</span>
                                <input type="text" class="form-control text-center" id="LBRNCH" name="LBRNCH">
                            </div>
                            <div class="input-group input-group-sm mb-3">
                                <span class="input-group-text" id="inputGroup-sizing-sm">HBRNCH</span>
                                <input type="text" class="form-control text-center" id="HBRNCH" name="HBRNCH">
                            </div>
                            <div class="input-group input-group-sm mb-3">
                                <span class="input-group-text" id="inputGroup-sizing-sm">LDOCTYPE</span>
                                <input type="text" class="form-control text-center" id="LDOCTYPE" name="LDOCTYPE">
                            </div>
                            <div class="input-group input-group-sm mb-3">
                                <span class="input-group-text" id="inputGroup-sizing-sm">HDOCTYPE</span>
                                <input type="text" class="form-control text-center" id="HDOCTYPE" name="HDOCTYPE">
                            </div>
                            <button class="btn btn-sm btn-success w-100" type="button" onclick="getdataetax()">ค้นหา</button>
                        </div>
                        
                    </div>
                </div>
            </div>
            
            <div class="card mt-3 shadow" >
                <div class="card-header">
                    เเสดงรายการ
                </div>
                <div class="card-body">
                    
                    <table class="table text-nowrap table-bordered table-sm" id="table_etax">
                        
                    </table>
                </div>
            </div>
            <%@ include file="share/footer.jsp" %>
        </div>
        
        <script>
            function download(url, filename) {
                fetch(url)
                .then(response => response.blob())
                .then(blob => {
                    const link = document.createElement("a");
                    link.href = URL.createObjectURL(blob);
                    link.download = filename;
                    link.click();
                })
                .catch(console.error);
            }
            
            function savefile(){
                var BUKRS = "1111";
                var LBLDAT = "2022-12-01";
                var HBLDAT = "2023-01-03";
                var LKUNRG = "1110000001";
                var HKUNRG = "1110000001";
                var LBRNCH = "00000";
                var HBRNCH = "00016";
                var LDOCTYPE = "T03";
                var HDOCTYPE = "T03";
        
                /*
                var BUKRS = $("#BUKRS").val();
                var LBLDAT = $("#LBLDAT").val();
                var HBLDAT = $("#HBLDAT").val();
                var LKUNRG = $("#LKUNRG").val();
                var HKUNRG = $("#HKUNRG").val();
                var LBRNCH = $("#LBRNCH").val();
                var HBRNCH = $("#HBRNCH").val();
                var LDOCTYPE = $("#LDOCTYPE").val();
                var HDOCTYPE = $("#HDOCTYPE").val();
                 */
                $.ajax({
                    type:"post",
                    url:"Etax",
                    data:{
                        type:"savefile",
                        BUKRS:BUKRS,
                        LBLDAT:LBLDAT,
                        HBLDAT: HBLDAT,
                        LKUNRG:LKUNRG,  
                        HKUNRG:HKUNRG,  
                        LBRNCH:LBRNCH,
                        HBRNCH:HBRNCH,
                        LDOCTYPE:LDOCTYPE,
                        HDOCTYPE:HDOCTYPE
                    },
                    success:function(url){
                        var js = JSON.parse(url)
                        download(js.url,js.filename)
                    }
                })
            }
            
            function getdataetax(){
                var BUKRS = "1111";
                var LBLDAT = "2022-12-01";
                var HBLDAT = "2023-01-03";
                var LKUNRG = "1110000001";
                var HKUNRG = "1110000001";
                var LBRNCH = "00000";
                var HBRNCH = "00016";
                var LDOCTYPE = "T03";
                var HDOCTYPE = "T03";
        
                /*
                var BUKRS = $("#BUKRS").val();
                var LBLDAT = $("#LBLDAT").val();
                var HBLDAT = $("#HBLDAT").val();
                var LKUNRG = $("#LKUNRG").val();
                var HKUNRG = $("#HKUNRG").val();
                var LBRNCH = $("#LBRNCH").val();
                var HBRNCH = $("#HBRNCH").val();
                var LDOCTYPE = $("#LDOCTYPE").val();
                var HDOCTYPE = $("#HDOCTYPE").val();
                 */
                $.ajax({
                    type:"post",
                    url:"Etax",
                    data:{
                        type:"getdataformsap",
                        BUKRS:BUKRS,
                        LBLDAT:LBLDAT,
                        HBLDAT: HBLDAT,
                        LKUNRG:LKUNRG,  
                        HKUNRG:HKUNRG,  
                        LBRNCH:LBRNCH,
                        HBRNCH:HBRNCH,
                        LDOCTYPE:LDOCTYPE,
                        HDOCTYPE:HDOCTYPE
                    },
                    success:function(msg){
                        var json = JSON.parse(msg)
                        if(json.data.length > 0){
                            Swal.fire({
                                title:"ค้นหา",
                                text:"พบข้อมูลทั้งหมด : " +json.data.length+" เเถว",
                                icon:"success"
                            })
                        }else{
                            Swal.fire({
                                title:"ค้นหา",
                                text:"ไม่พบข้อมูล",
                                icon:"error"
                            })
                        }
                        $('#table_etax').DataTable( {
                            dom: 'Bfrtip',
                            buttons: [
                                'pageLength',
                                {
                                    text: 'Csv',
                                    action: function ( e, dt, node, config ) {
                                        savefile()
                                    }
                                },
                                
                                'excel'
                            ],
                            data: json.data,
                            columns:json.datacol,
                            scrollX: true,
                            destroy: true
                        } );
                    }
                })
            }
            
            
            $(document).ready(function(){
            
            })
        </script>
    </body>
</html>
