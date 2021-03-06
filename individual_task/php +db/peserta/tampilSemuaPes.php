<?php 
	//Import File Koneksi Database
	require_once('koneksi.php');
	
	//Membuat SQL Query
	$sql = "SELECT * FROM `peserta`";
	
	//Mendapatkan Hasil
	$r = mysqli_query($con,$sql);
	
	//Membuat Array Kosong 
	$result = array();
	
	while($row = mysqli_fetch_array($r)){
		
		//Memasukkan Nama dan ID kedalam Array Kosong yang telah dibuat 
		array_push($result,array(
			"id"=>$row['pes_id'],
			"name"=>$row['pes_nama'],
			"number" => $row['pes_hp'],
			"email" => $row['pes_email'],
			"agency" => $row['pes_instansi'],
		));
	}
	
	//Menampilkan Array dalam Format JSON
	echo json_encode($result);
	
	mysqli_close($con);
?>