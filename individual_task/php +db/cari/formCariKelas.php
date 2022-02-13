<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="../assets/images/favicon.png">
    <title>Adminmart Template - The Ultimate Multipurpose admin template</title>
    <!-- Custom CSS -->
    <link href="../dist/css/style.min.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<style>
    body{
    margin-top:20px;
    background:#f4ffff;
}
.candidates-listing-bg {
  padding: 210px 0px 60px 0px;
  background-image: url("../images/candidates-listing-bg.jpg");
  background-size: cover;
  position: relative;
  background-position: center center;
}

.custom-checkbox .custom-control-input:checked ~ .custom-control-label:before {
  background-color: #ff4f6c;
  border-color: #ff4f6c;
}

.custom-checkbox .custom-control-input:focus ~ .custom-control-label:before {
  -webkit-box-shadow: none;
          box-shadow: none;
}

.candidates-img img {
  max-width: 90px;
}

.fav-icon i {
  -webkit-text-stroke: 2px #ff4f6c;
  -webkit-text-fill-color: transparent;
}

.fav-icon i:hover {
  -webkit-text-stroke: 0px #ff4f6c;
  -webkit-text-fill-color: #ff4f6c;
}

.candidates-list-desc {
  overflow: hidden;
}

.candidates-right-details {
  position: absolute;
  top: 0;
  right: 20px;
}

.candidates-item-desc {
  margin-left: 45px;
}

.list-grid-item {
  border: 1px solid #ececec;
  border-radius: 6px;
  -webkit-transition: all 0.5s;
  transition: all 0.5s;
}

.list-grid-item:hover {
  -webkit-box-shadow: 0 0 20px 0px rgba(47, 47, 47, 0.09);
          box-shadow: 0 0 20px 0px rgba(47, 47, 47, 0.09);
  -webkit-transition: all 0.5s;
  transition: all 0.5s;
  border-color: transparent;
}

.left-sidebar .card-body {
    border-bottom: 1px solid #ececec;
}

.custom-control {
    margin: 11px 20px;
}

.card-header {
    background-color: transparent;
    margin-bottom: 0 !important;
}

.pagination.job-pagination .page-link {
  border-radius: 50% !important;
  margin: 0 4px;
  height: 46px;
  width: 45px;
  line-height: 29px;
  text-align: center;
  color: #777777;
}

.page-item.active .page-link {
  background-color: #ff4f6c;
  border-color: #ff4f6c;
  color: #ffffff !important;
}

.f-14 {
    font-size: 14px;
}

.btn-outline {
    color: #ff4f6c;
    border-color: #ff4f6c;
}
.btn-sm {
    padding: 8px 22px;
}
</style>

<body>
    <!-- ============================================================== -->
    <!-- Preloader - style you can find in spinners.css -->
    <!-- ============================================================== -->
    <div class="preloader">
        <div class="lds-ripple">
            <div class="lds-pos"></div>
            <div class="lds-pos"></div>
        </div>
    </div>
    <!-- ============================================================== -->
    <!-- Main wrapper - style you can find in pages.scss -->
    <!-- ============================================================== -->
    <div id="main-wrapper" data-theme="light" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full" data-sidebar-position="fixed" data-header-position="fixed" data-boxed-layout="full">
        <!-- ============================================================== -->
        <!-- Topbar header - style you can find in pages.scss -->
        <!-- ============================================================== -->
       
        <!-- ============================================================== -->
        <!-- End Topbar header -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        
        <!-- ============================================================== -->
        <!-- End Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Page wrapper  -->
        <!-- ============================================================== -->
        <div class="page-wrapper" style= "margin-top : -100px"> 
            <!-- ============================================================== -->
            <!-- Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <div class="page-breadcrumb">
                <div class="row">
                    <div class="col-7 align-self-center">
                        
                    </div>
                    <!-- <div class="col-5 align-self-center">
                        <div class="customize-input float-right">
                            <select class="custom-select custom-select-set form-control bg-white border-0 custom-shadow custom-radius">
                                <option selected>Aug 19</option>
                                <option value="1">July 19</option>
                                <option value="2">Jun 19</option>
                            </select>
                        </div>
                    </div> -->
                </div>
            </div>
            <!-- ============================================================== -->
            <!-- End Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid">
                <!-- ============================================================== -->
                <!-- Start Page Content -->
                <!-- ============================================================== -->
                <?php     
                    $link = "http://".$_SERVER['SERVER_NAME'];    
                ?>
                
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">                            
                                <h4 class="card-title">Cari Kelas Berdasar Tanggal </h4>
                                <form action=<?=$link."/individual_task/cari/formCariKelas.php"?> method="GET">
                                    <div class="form-body">
                                        <div class="row">
                                            <div class="col-md-1">
                                                <p></p>
                                            </div>
                                            <div class="col-md-11">
                                                <div class="form-group">
                                                    <label>Tanggal Mulai (DD-MM-YYYY)</label>
                                                    <input type="date" class="form-control" placeholder="Tanggal Mulai" id ="kel_tgl_mulai" name = "kel_tgl_mulai" required>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-1">
                                                <div class="form-group">
                                                    <label>Tanggal Berakhir (DD-MM-YYYY)</label>
                                                    <input type="date" class="form-control" placeholder="Tanggal Akhir" id ="kel_tgl_akhir" name = "kel_tgl_akhir" required>
                                                </div>
                                            </div>
                                            
                                        </div>
                                    <div class="form-actions">
                                        <div class="text-right">
                                            <button type="submit" class="btn btn-info">Submit</button>
                                            <button class = "btn btn-danger" onclick = "showAndroidToast('Hello Android')">Batal</button>
                                            <script>
                                                function showAndroidToast(toast) {
                                                    Android.showToast(toast);
                                                }
                                            </script>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header btn-danger">
        <h5 class="modal-title " id="exampleModalLabel">Anda Yakin Hapus Data??</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <h3>Data : </h3><h3 id = "delete_name"></h3>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <a id="link_delete"><button class="btn btn-danger">Delete</button></a>
        
      </div>
    </div>
  </div>
</div>
               
                <!-- ============================================================== -->
                <!-- End PAge Content -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Right sidebar -->
                <!-- ============================================================== -->
                <!-- .right-sidebar -->
                <!-- ============================================================== -->
                <!-- End Right sidebar -->
                <!-- ============================================================== -->
            </div>
            <?php 
                if(isset($_GET['kel_tgl_mulai'])){
                    ?>
                
    <div class="row">
        <div class="col-lg-9">
            <div class="candidates-listing-item">
                <div class="list-grid-item mt-4 p-2  card">
                    <div id="row_cari">

                    </div>

                <?php
                }
            ?>
            
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- footer -->
            <!-- ============================================================== -->
           
            <!-- ============================================================== -->
            <!-- End footer -->
            <!-- ============================================================== -->
        </div>
        <!-- ============================================================== -->
        <!-- End Page wrapper  -->
        <!-- ============================================================== -->
    </div>
    <!-- ============================================================== -->
    <!-- End Wrapper -->
    <!-- ============================================================== -->
    <!-- End Wrapper -->
    <!-- ============================================================== -->
    <!-- All Jquery -->
    <!-- ============================================================== -->
    <script src="../assets/libs/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap tether Core JavaScript -->
    <script src="../assets/libs/popper.js/dist/umd/popper.min.js"></script>
    <script src="../assets/libs/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- apps -->
    <!-- apps -->
    <script src="../dist/js/app-style-switcher.js"></script>
    <script src="../dist/js/feather.min.js"></script>
    <!-- slimscrollbar scrollbar JavaScript -->
    <script src="../assets/libs/perfect-scrollbar/dist/perfect-scrollbar.jquery.min.js"></script>
    <script src="../assets/extra-libs/sparkline/sparkline.js"></script>
    <!--Wave Effects -->
    <!-- themejs -->
    <!--Menu sidebar -->
    <script src="../dist/js/sidebarmenu.js"></script>
    <!--Custom JavaScript -->
    <script src="../dist/js/custom.min.js"></script>
   
    <script>
       new Promise(function(resolve, reject) {

            setTimeout(() => resolve(1), 500); // (*)

            }).then(function(result) { // (**)

                $.getJSON("<?=$link?>/individual_task/cari/tampilSemuaCari.php?kel_tgl_mulai=<?=$_GET['kel_tgl_mulai']?>&kel_tgl_akhir=<?=$_GET['kel_tgl_akhir']?>",
                function (json) {
                    $.each(json,
                        function (key, value) {
                        
                        var html =`<div class="row">
                        <div class="col-md-9">
                            <div class="candidates-list-desc job-single-meta  pt-2">
                                <h5 class="mb-2 f-19"><a href="#" class="text-dark">${value.ins_nama}</a></h5>
                                <ul class="list-inline mb-0">
                                    <li class="list-inline-item mr-4">
                                        <p class="text-muted f-15 mb-0"><i class="mdi mdi-account mr-1"></i>Materi: ${value.mat_nama}</p>
                                    </li>

                                    <li class="list-inline-item mr-4">
                                        <p class="f-15 mb-0"><a href="" class="text-muted"><i class="mdi mdi-map-marker mr-1"></i>${value.ins_kontak}</a></p>
                                    </li>
                                    <li class="list-inline-item mr-4">
                                        <p class="text-muted f-15 mb-0"><i class="mdi mdi-account mr-1"></i>${value.hari} Hari ${value.bulan} Bulan ${value.tahun} Tahun</p>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>`;

                        $("#row_cari").append(html);
                    });
                    $('#ins_id').on('change',function(){
                        var number = $(this).children('option:selected').data('number');
                        var email = $(this).children('option:selected').data('email');
                        var kontak = number + " / " + email;
                        $('#ins_kontak').val(kontak);
                        $('#txt_ins').css("visibility", "visible");
                    });
                });
                
                return result;

            }).then(function(result) { // (***)

                $.getJSON("<?=$link?>/individual_task/materi/tampilSemuaMat.php",
                function (json) {
                    $.each(json,
                        function (key, value) {
                            // console.log(value);
                            $("#mat_id").append("<option value='" + value.id+ "' data-materi= '"+value.name+"'>" + value.name+ "</option>");
                            $('#mat_id').on('change',function(){
                            
                        });
                    });
                });
                return result;

            });
    </script>
    
</body>

</html>