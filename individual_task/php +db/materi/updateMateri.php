<?php 
	session_start();
	if($_SERVER['REQUEST_METHOD']=='POST'){
		//Mendapatkan Nilai Dari Variable 
		$id = $_POST['mat_id'];
		$name = $_POST['mat_nama'];
		
		//import file koneksi database 
		require_once('koneksi.php');
		
		//Membuat SQL Query
		$sql = "UPDATE `materi` SET `mat_nama` = '$name' WHERE `materi`.`mat_id` = $id";
		
		//Meng-update Database 
		$link = 'http://'.$_SERVER['SERVER_NAME']."/individual_task/materi/tabelMateri.php";
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