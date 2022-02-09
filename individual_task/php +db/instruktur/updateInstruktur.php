<?php 
	session_start();
	if($_SERVER['REQUEST_METHOD']=='POST'){
		//Mendapatkan Nilai Dari Variable 
		$id = $_POST['ins_id'];
		$name = $_POST['ins_nama'];
		$email = $_POST['ins_email'];
		$number = $_POST['ins_hp'];
		
		//import file koneksi database 
		require_once('koneksi.php');
		
		//Membuat SQL Query
		$sql = "UPDATE `instruktur` SET 
		`ins_nama` = '$name', 
		`ins_email` = '$email', 
		`ins_hp` = '$number' WHERE 
		`instruktur`.`ins_id` = $id";
		
		//Meng-update Database 
		$link = 'http://'.$_SERVER['SERVER_NAME']."/individual_task/instruktur/tabelInstruktur.php";
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