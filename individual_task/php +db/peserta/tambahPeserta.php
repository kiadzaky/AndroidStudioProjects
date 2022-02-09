<?php
session_start();
	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Mendapatkan Nilai Variable
		$pes_nama = $_POST['pes_nama'];
		$pes_email = $_POST['pes_email'];
		$pes_hp = $_POST['pes_hp'];
		$pes_instansi = $_POST['pes_instansi'];
		
		//Pembuatan Syntax SQL
		$sql = "INSERT INTO `peserta` (`pes_id`, `pes_nama`, `pes_email`, `pes_hp`, `pes_instansi`) 
		VALUES (NULL, '$pes_nama', '$pes_email', '$pes_hp', '$pes_instansi')";
		
		$_SESSION['pes_nama'] = $pes_nama;
		$_SESSION['pes_email'] = $pes_email;
		$_SESSION['pes_hp'] = $pes_hp;
		$_SESSION['pes_instansi'] = $pes_instansi;

		//Import File Koneksi database
		require_once('koneksi.php');
		
		//Eksekusi Query database
		$_SESSION['modal'] = TRUE;
		if(mysqli_query($con,$sql)){
			$_SESSION['kata'] = 'Berhasil Tambah Data';
			$_SESSION['warna'] = 'btn-success';
			
		}else{
			$_SESSION['kata'] = 'Gagal Tambah Data';
			$_SESSION['warna'] = 'btn-danger';
		}
		$link = 'http://'.$_SERVER['SERVER_NAME']."/individual_task/peserta/tabelPeserta.php";
			header('location:'.$link);
			exit();
			die();
		mysqli_close($con);
	}
?>