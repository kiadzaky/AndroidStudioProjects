<?php 
	session_start();
	if($_SERVER['REQUEST_METHOD']=='POST'){
		//Mendapatkan Nilai Dari Variable 
		$id = $_POST['kel_id'];
		$kel_tgl_mulai = $_POST['kel_tgl_mulai'];
		$kel_tgl_akhir = $_POST['kel_tgl_akhir'];
		$ins_id = $_POST['ins_id'];
		$mat_id = $_POST['mat_id'];
		
		//import file koneksi database 
		require_once('koneksi.php');
		
		//Membuat SQL Query
		$sql = "UPDATE `kelas` SET 
		`kel_tgl_mulai` = '$kel_tgl_mulai', 
		`kel_tgl_akhir` = '$kel_tgl_akhir', 
		`ins_id` = '$ins_id', 
		`mat_id` = '$mat_id' 
		WHERE `kelas`.`kel_id` = $id";
		
		//Meng-update Database 
		$link = 'http://'.$_SERVER['SERVER_NAME']."/individual_task/kelas/tabelKelas.php";
		$_SESSION['modal'] = TRUE;
		if(mysqli_query($con,$sql)){
			
			$_SESSION['kata'] = 'Berhasil Sunting Data';
			$_SESSION['warna'] = 'btn-success';
			
		}else{
			$_SESSION['kata'] = 'Gagal Sunting Data';
			$_SESSION['warna'] = 'btn-danger';
		}
		header('location:'.$link);
			exit();
			die();
		mysqli_close($con);
	}
?>