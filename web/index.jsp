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
        <style>
            #all_bill p {
                display: inline; /* ทำให้ <p> เป็น inline element */
                margin: 0; /* ลบการเว้นระหว่าง <p> */
                padding: 0; /* ลบการเว้นระหว่าง <p> */
            }
        </style>
    </head>
    <body>
        
        <div class="modal fade" id="modal_userpassetax" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">ดูรหัสผ่าน User/Pass One-Etax</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="text-center">
                            >>>> <a href="https://etax.one.th/portal/login" target="_blank">Web One-Etax</a> <<<<<br>
                            <br>
                            เข้าระบบ Web Portal<br>
                            Username : account123<br>
                            Password : Account@123<br>
                            Tax ID      : 0107537001552<br>
                            <br>
                            เข้า sFTP CLIENT<br>
                            Username : account<br>
                            Password : Acc@pg666<br>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="modal fade" id="modal_manual" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-xl">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">คู่มือ DATA ETAX</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <iframe src="DATA_ETAX.pdf" style="width:100%; height:60vh;" frameborder="1"></iframe>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="mx-5">
            <div class="text-center h1 fw-bold mt-3">
                GET DATA ETAX
            </div>
            <div class="row">
                <div class="col-sm-12 col-md-3">
                    <div class="card mt-3 shadow" >
                        <div class="card-header">
                            ค้นหา
                        </div>
                        <div class="card-body">
                            <div class="row ">
                                <div class="col-sm-12 col-md-12 mx-auto">
                                    <div class="input-group input-group-sm mb-3">
                                        <span class="input-group-text" id="inputGroup-sizing-sm">BUKRS</span>
                                        <input type="text" class="form-control text-center" id="BUKRS" name="BUKRS" value="1111">
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
                                        <span class="input-group-text" id="inputGroup-sizing-sm">LBRNCH</span>
                                        <input type="text" class="form-control text-center" id="LBRNCH" name="LBRNCH" value="00000">
                                    </div>
                                    <div class="input-group input-group-sm mb-3">
                                        <span class="input-group-text" id="inputGroup-sizing-sm">HBRNCH</span>
                                        <input type="text" class="form-control text-center" id="HBRNCH" name="HBRNCH" value="00016">
                                    </div>
                                    <div class="input-group input-group-sm mb-3">
                                        <span class="input-group-text" id="inputGroup-sizing-sm">LDOCTYPE</span>
                                        <select class="form-select text-center" id="DOCTYPE" name="DOCTYPE">
                                            <option value="T03">T03</option>
                                            <option value="80">80</option>
                                            <option value="81">81</option>
                                            <option value="388">388</option>
                                            <option value="ALL">ALL</option>
                                        </select>
                                    </div>
                                    <div class="d-flex justify-content-evenly">
                                        <button class="btn btn-sm btn-success w-50 " type="button" onclick="getdataetax()">ค้นหา</button>
                                        &nbsp;&nbsp;
                                        <button class="btn btn-sm btn-primary w-50" type="button" onclick="getuserpassetax()">ดูรหัสผ่าน  One-Etax </button>
                                    </div>
                                    <div class="d-flex justify-content-center mt-2">
                                        <button class="btn btn-sm btn-secondary w-100" type="button" onclick="$('#modal_manual').modal('show')">คู่มือ DATA ETAX</button>
                                    </div>
                                    
                                </div>
                                
                                
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12 col-md-8">
                    <div class="card mt-3 shadow" >
                        <div class="card-header">
                            เเสดงรายการ
                        </div>
                        <div class="card-body">
                            
                            <div class="d-flex justify-content-between mt-3">
                                <div class="text-end fw-bold h4" id="txt2"></div>
                                <div class="text-end fw-bold  h4" id="all_bill"></div>
                            </div>
                            
                            <table class="table text-nowrap table-bordered table-sm w-100" id="table_etax_sum">
                                
                            </table>
                            <br>
                            <div class="text-center fw-bold" id='tb_fullsum'>
                                
                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
            <%@ include file="share/footer.jsp" %>
        </div>
        
        <script>
            
            function getdataetax(){
                Swal.fire({
                    title: 'Loading...',
                    allowOutsideClick: false, // Prevent users from closing the dialog
                    didOpen: () => {
                        Swal.showLoading();
                    },
                    showConfirmButton: false
                });
                
                $("#txt1").text("รายละเอียดบิลทั้งหมด")
                $("#txt2").text("รายละเอียดบิลสรุปทั้งหมด")
                $('#table_etax').empty()
                $('#table_etax_sum').empty()
              
          
                gettbdataetaxsum()
                
            }
    
            function getuserpassetax(){
                $('#modal_userpassetax').modal('show')
            }
            
            function today(){
                const currentDate = new Date();
                const year = currentDate.getFullYear();
                const month = currentDate.getMonth() + 1; // Month is 0-based, so we add 1 to get the correct month
                const day = currentDate.getDate();
                const hours = currentDate.getHours();
                const minutes = currentDate.getMinutes();
                const seconds = currentDate.getSeconds();

                const date = day + "_" + month+ "_"+ year;
                return date
            }
            
   
            function savefile(){
                Swal.fire({
                    title: 'Loading...',
                    allowOutsideClick: false, // Prevent users from closing the dialog
                    didOpen: () => {
                        Swal.showLoading();
                    },
                    showConfirmButton: false
                });
                
                var BUKRS = $("#BUKRS").val();
                var LBLDAT = $("#LBLDAT").val();
                var HBLDAT = $("#HBLDAT").val();
                var LBRNCH = $("#LBRNCH").val();
                var HBRNCH = $("#HBRNCH").val();
                var DOCTYPE = $("#DOCTYPE").val(); 
                
                $.ajax({
                    type:"post",
                    url:"Etax",
                    data:{
                        type:"savefile",
                        BUKRS:BUKRS,
                        LBLDAT:LBLDAT,
                        HBLDAT: HBLDAT,
                        LBRNCH:LBRNCH,
                        HBRNCH:HBRNCH,
                        DOCTYPE:DOCTYPE
                    },
                    success:function(url){
                        Swal.close()
                        
                        var js = JSON.parse(url)
                        var data = "";
                        
                        $(js.data).each(function(k,v){
                            var list = v
                            
                            $(list).each(function(k1,v1){
                                if(k1 < list.length-1){
                                    data += '"'+ v1 + '",';
                                }else if(k1 == list.length-1){
                                    data += '"'+ v1 + '"';
                                }
                            })
                            data += "\n";
                       
                        })
                        console.log(data)
                        
                        const BOM = '\uFEFF';
                        const fileName = 'DATA_ETAX_'+today()+'.csv'; // Set the desired file name here
                        const blob = new Blob([BOM + data], { type: 'text/csv;charset=utf-8' });

                        const link = window.URL.createObjectURL(blob);
                        const linkElem = document.createElement('a');
                        linkElem.href = link;
                        linkElem.download = fileName; // Set the 'download' attribute to specify the file name
                        linkElem.click();
                        // window.open("https://etax.one.th/portal/login")
                    }
                })
            }
           

            function gettbdataetaxsum(){
               
                var BUKRS = $("#BUKRS").val();
                var LBLDAT = $("#LBLDAT").val();
                var HBLDAT = $("#HBLDAT").val();
                var LBRNCH = $("#LBRNCH").val();
                var HBRNCH = $("#HBRNCH").val();
                var DOCTYPE = $("#DOCTYPE").val(); 
                
                console.log(DOCTYPE)
                 
                $.ajax({
                    type:"post",
                    url:"Etax",
                    data:{
                        type:"getdatasumetax",
                        BUKRS:BUKRS,
                        LBLDAT:LBLDAT,
                        HBLDAT: HBLDAT,
                        LBRNCH:LBRNCH,
                        HBRNCH:HBRNCH,
                        DOCTYPE:DOCTYPE
                    },
                    success:function(msg){
                        Swal.close()
                        
                        var json = JSON.parse(msg)
                     
                        console.log(msg)
                        if(msg && json.data.length > 0){
                            
                            Swal.fire({
                                title:'ค้นหาสำเร็จ',
                                text:'พบข้อมูล ' +json.data.length + ' บิล',
                                icon:'success'
                            })
                            
                            $("#BASICAMTTOTAL").text(json.BASICAMT_TOTAL);
                            $("#TAXAMTTOTAL").text(json.TAXAMT_TOTAL);
                            $("#GRANDAMTTOTAL").text(json.GRANDAMT_TOTAL);
                            
                            $("#all_bill").html("<p>จำนวนบิลทั้งหมด </p><p class='text-success'>" + json.data.length + "</p> บิล");
                            
                            var html = "<div class='text-center fw-bold h4'>ยอดรวมทั้งหมด</div>";
                            html +=  "<table class='table text-nowrap table-bordered table-sm w-100'>";
                            html += "<thead>";
                            html += "<tr>";
                            html += "<th>BASICAMT_TOTAL</th>";
                            html += "<th>TAXAMT_TOTAL</th>";
                            html += "<th>GRANDAM_TTOTAL</th>";
                            html += "</tr>";
                            html += "</thead>";
                            html += "<tbody>";
                            html += "<tr>";
                            html += "<td>"+json.BASICAMT_TOTAL+"</td>";
                            html += "<td>"+json.TAXAMT_TOTAL+"</td>";
                            html += "<td>"+json.GRANDAMT_TOTAL+"</td>";
                            html += "</tr>";
                            html += "</tbody>";
                            html += " </table>";
            
            
            $("#tb_fullsum").html(html)
            
                            $('#table_etax_sum').DataTable({
                                lengthMenu: [[10, 25, 50,100,-1], [10, 25, 50,100 ,"All"]],
                                dom: 'Bfrtip',
                                buttons: [
                                    'pageLength',
                                    {
                                        text: 'Csv',
                                        action: function ( e, dt, node, config ) {
                                            savefile()
                                        }
                                    },
                                    {
                                        extend: 'excel',
                                        filename: 'DATA_ETAX_ALLBILL_'+today(),
                                        title: 'DATA_ETAX_ALLBILL_'+today()
                                    },
                                ],
                                data: json.data,
                                columns:json.datacols,
                                scrollX: true,
                                destroy: true,
                                order: [[2,'asc']]
                            });
                            

                        }else{
                            $("#all_bill").html("จำนวนบิลทั้งหมด " + json.data.length + " บิล")
                            Swal.fire({
                                title:'ค้นหาไม่สำเร็จ',
                                text:'ไม่พบข้อมูล',
                                icon:'error'
                            })
            
                        }
                        

                    }
                })
            }

            function gettbdataetaxall(){
               
                var BUKRS = $("#BUKRS").val();
                var LBLDAT = $("#LBLDAT").val();
                var HBLDAT = $("#HBLDAT").val();
                var LKUNRG = $("#LKUNRG").val();
                var HKUNRG = $("#HKUNRG").val();
                var LBRNCH = $("#LBRNCH").val();
                var HBRNCH = $("#HBRNCH").val();
                var LDOCTYPE = $("#DOCTYPE").val(); 
                var HDOCTYPE = $("#HDOCTYPE").val();
                 
        
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
                        Swal.close()
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
                            destroy: true,
                            order: [[2,'asc']]
                        } );
                        

                    }
                })
            }
            
            
            $(document).ready(function(){
                  
            })
        </script>
    </body>
</html>
