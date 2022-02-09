<?php 
	//Mendapatkan Nilai Dari Variable ID Pegawai yang ingin ditampilkan
	$id = $_GET['id'];
	
	//Importing database
	require_once('koneksi.php');
	
	//Membuat SQL Query dengan pegawai yang ditentukan secara spesifik sesuai ID
	$sql = "SELECT * FROM `instruktur` WHERE ins_id=$id";
	
	//Mendapatkan Hasil 
	$r = mysqli_query($con,$sql);
	
	//Memasukkan Hasil Kedalam Array
	$result = array();
	$row = mysqli_fetch_array($r);
	array_push($result,array(
			"id"=>$row['ins_id'],
			"name"=>$row['ins_nama'],
			"email"=>$row['ins_email'],
			"number"=>$row['ins_hp'],
		));

	//Menampilkan dalam format JSON
	echo json_encode($result);
	
	mysqli_close($con);
?>