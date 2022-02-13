<?php 
	session_start();
	if($_SERVER['REQUEST_METHOD']=='POST'){
		//Mendapatkan Nilai Dari Variable 
		$det_kel_id = $_POST['det_kel_id'];
        $id = $_POST['pes_id'];

		
		//import file koneksi database 
		require_once('koneksi.php');
		
		//Membuat SQL Query
		$sql = "UPDATE `detail_kelas` SET `pes_id` = '$id' WHERE `detail_kelas`.`det_kel_id` = $det_kel_id";
		
		//Meng-update Database 
		$link = 'http://'.$_SERVER['SERVER_NAME']."/individual_task/detail_kelas/tabelDetKelas.php";
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