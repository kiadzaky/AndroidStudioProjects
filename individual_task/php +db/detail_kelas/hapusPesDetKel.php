<?php 
 //Mendapatkan Nilai ID
 session_start();
 $id = $_GET['id'];
 
 //Import File Koneksi Database
 require_once('koneksi.php');
 
 //Membuat SQL Query
 $sql = "DELETE FROM `detail_kelas` WHERE `detail_kelas`.`det_kel_id` = $id";

 
 //Menghapus Nilai pada Database 
 $_SESSION['modal'] = TRUE;
 if(mysqli_query($con,$sql)){
   
   $_SESSION['kata'] = 'Berhasil Hapus Data';
   $_SESSION['warna'] = 'btn-success';
    
 }else{
   $_SESSION['kata'] = 'Gagal Hapus Data';
   $_SESSION['warna'] = 'btn-danger';
 }
 $link = 'http://'.$_SERVER['SERVER_NAME']."/individual_task/detail_kelas/tabelDetKelas.php";
    header('location:'.$link);
    exit();
    die();
 mysqli_close($con);
 ?>