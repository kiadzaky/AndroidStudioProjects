<?php 
	session_start();
	if($_SERVER['REQUEST_METHOD']=='POST'){
		//Mendapatkan Nilai Dari Variable 
		$id = $_POST['pes_id'];
		$name = $_POST['pes_nama'];
		$email = $_POST['pes_email'];
		$number = $_POST['pes_hp'];
		$agency = $_POST['pes_instansi'];
		
		//import file koneksi database 
		require_once('koneksi.php');
		
		//Membuat SQL Query
		$sql = "UPDATE `peserta` SET `pes_nama` = '$name', 
			`pes_email` = '$email', 
			`pes_hp` = '$number', 
			`pes_instansi` = '$agency' WHERE `peserta`.`pes_id` = $id";
		
		//Meng-update Database 
		$link = 'http://'.$_SERVER['SERVER_NAME']."/individual_task/peserta/tabelPeserta.php";
		$_SESSION['modal'] = TRUE;
		if(mysqli_query($con,$sql)){
			
			$_SESSION['kata'] = 'Berhasil Sunting Data';
			$_SESSION['warna'] = 'btn-success';
			
		}else{
			$_SESSION['kata'] = 'Berhasil Sunting Data';
			$_SESSION['warna'] = 'btn-success';
		}
		header('location:'.$link);
			exit();
			die();
		mysqli_close($con);
	}
?>