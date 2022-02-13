<?php
session_start();
	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Mendapatkan Nilai Variable
		$ins_nama = $_POST['ins_nama'];
		$ins_email = $_POST['ins_email'];
		$ins_hp = $_POST['ins_hp'];
		
		//Pembuatan Syntax SQL
		$sql = "INSERT INTO `instruktur` (`ins_id`, `ins_nama`, `ins_email`, `ins_hp`) 
		VALUES (NULL, '$ins_nama', '$ins_email', '$ins_hp')";
		
		$_SESSION['pes_nama'] = $ins_nama;
		$_SESSION['pes_email'] = $ins_email;
		$_SESSION['pes_hp'] = $ins_hp;
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
		$link = 'http://'.$_SERVER['SERVER_NAME']."/individual_task/instruktur/tabelInstruktur.php";
			header('location:'.$link);
			exit();
			die();
		mysqli_close($con);
	}
?>