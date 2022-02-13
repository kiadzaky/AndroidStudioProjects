<?php
session_start();
	if($_SERVER['REQUEST_METHOD']=='POST'){
		require_once('koneksi.php');
		//Mendapatkan Nilai Variable
		$kel_tgl_mulai = $_POST['kel_tgl_mulai'];
		$kel_tgl_akhir = $_POST['kel_tgl_akhir'];
		$ins_id = $_POST['ins_id'];
		$mat_id = $_POST['mat_id'];
		
		//Pembuatan Syntax SQL
		$sql = "INSERT INTO `kelas` 
		(`kel_id`, `kel_tgl_mulai`, `kel_tgl_akhir`, `ins_id`, `mat_id`) 
		VALUES 
		(NULL, '$kel_tgl_mulai', '$kel_tgl_akhir', '$ins_id', '$mat_id')";
		
		$sql1 = "
		SELECT * FROM `kelas`
			JOIN instruktur ON kelas.ins_id = instruktur.ins_id
			JOIN materi ON kelas.mat_id = materi.mat_id
		";
		$r = mysqli_query($con,$sql1);

		while($row = mysqli_fetch_array($r)){
		
			//Memasukkan Nama dan ID kedalam Array Kosong yang telah dibuat 
			$_SESSION['kel_id'] = $row['kel_id'];
			$_SESSION['kel_tgl_mulai'] = $row['kel_tgl_mulai'];
			$_SESSION['kel_tgl_akhir'] = $row['kel_tgl_akhir'];
			$_SESSION['ins_nama'] = $row['ins_nama'];
			$_SESSION['ins_kontak'] = $row['ins_email']." / ".$row['ins_hp'];
			$_SESSION['mat_nama'] = $row['mat_nama'];
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
		$link = 'http://'.$_SERVER['SERVER_NAME']."/individual_task/kelas/tabelKelas.php";
			header('location:'.$link);
			exit();
			die();
		mysqli_close($con);
	}
?>