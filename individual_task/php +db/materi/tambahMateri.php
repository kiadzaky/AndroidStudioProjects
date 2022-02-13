<?php
session_start();
	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Mendapatkan Nilai Variable
		$mat_nama = $_POST['mat_nama'];
		$ins_email = $_POST['ins_email'];
		$ins_hp = $_POST['ins_hp'];
		
		//Pembuatan Syntax SQL
		$sql = "INSERT INTO `materi` (`mat_id`, `mat_nama`) VALUES (NULL, '$mat_nama')";
		
		$_SESSION['pes_nama'] = $mat_nama;

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
		$link = 'http://'.$_SERVER['SERVER_NAME']."/individual_task/materi/tabelMateri.php";
			header('location:'.$link);
			exit();
			die();
		mysqli_close($con);
	}
?>