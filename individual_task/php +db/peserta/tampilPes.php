<?php 
	//Mendapatkan Nilai Dari Variable ID Pegawai yang ingin ditampilkan
	$id = $_GET['id'];
	
	//Importing database
	require_once('koneksi.php');
	
	//Membuat SQL Query dengan pegawai yang ditentukan secara spesifik sesuai ID
	$sql = "SELECT * FROM `peserta` WHERE pes_id=$id";
	
	//Mendapatkan Hasil 
	$r = mysqli_query($con,$sql);
	
	//Memasukkan Hasil Kedalam Array
	$result = array();
	$row = mysqli_fetch_array($r);
	array_push($result,array(
			"id"=>$row['pes_id'],
			"name"=>$row['pes_nama'],
			"email"=>$row['pes_email'],
			"number"=>$row['pes_hp'],
			"agency"=>$row['pes_instansi'],
		));

	//Menampilkan dalam format JSON
	echo json_encode($result);
	
	mysqli_close($con);
?>