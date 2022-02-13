<?php
session_start();
	if($_SERVER['REQUEST_METHOD']=='POST'){
		require_once('koneksi.php');
		//Mendapatkan Nilai Variable
		$kel_id = $_POST['kel_id'];
		$pes_id = $_POST['pes_id'];
		
		//Pembuatan Syntax SQL
		$sql = "INSERT INTO `detail_kelas` 
		(`det_kel_id`, `kel_id`, `pes_id`) 
		VALUES (NULL, '$kel_id', '$pes_id')";
		
		$sql1 = "
		SELECT * FROM `detail_kelas`
			JOIN kelas ON detail_kelas.kel_id = kelas.kel_id
			JOIN instruktur ON kelas.ins_id = instruktur.ins_id
			JOIN materi ON kelas.mat_id = materi.mat_id
			JOIN peserta ON detail_kelas.pes_id = peserta.pes_id
		ORDER BY det_kel_id DESC limit 1;
		";
		$r = mysqli_query($con,$sql1);

		while($row = mysqli_fetch_array($r)){
		
			//Memasukkan Nama dan ID kedalam Array Kosong yang telah dibuat 
			
			$_SESSION['ins_nama'] = $row['ins_nama'];
			$_SESSION['mat_nama'] = $row['mat_nama'];
			$_SESSION['pes_nama'] = $row['pes_nama'];
		}
		
		//Eksekusi Query database
		$_SESSION['modal'] = TRUE;
		if(mysqli_query($con,$sql)){
			$_SESSION['kata'] = 'Berhasil Tambah Data';
			$_SESSION['warna'] = 'btn-success';
			
		}else{
			$_SESSION['kata'] = 'Gagal Tambah Data';
			$_SESSION['warna'] = 'btn-danger';
		}
		$link = 'http://'.$_SERVER['SERVER_NAME']."/individual_task/detail_kelas/tabelDetKelas.php";
			header('location:'.$link);
			exit();
			die();
		mysqli_close($con);
	}
?>