<?php 
	//Import File Koneksi Database
	require_once('koneksi.php');
	
	//Membuat SQL Query
	$sql = "SELECT * FROM `kelas`
	JOIN instruktur ON kelas.ins_id = instruktur.ins_id
    JOIN materi ON kelas.mat_id = materi.mat_id";
	
	//Mendapatkan Hasil
	$r = mysqli_query($con,$sql);
	
	//Membuat Array Kosong 
	$result = array();
	
	while($row = mysqli_fetch_array($r)){
		
		//Memasukkan Nama dan ID kedalam Array Kosong yang telah dibuat 
		array_push($result,array(
			"id"=>$row['kel_id'],
			"date_mulai" => date('d-m-Y', strtotime($row['kel_tgl_mulai'])),
			"name_instruktur"=>$row['ins_nama'],
			"name_materi"=>$row['mat_nama'],
		));
	}
	
	//Menampilkan Array dalam Format JSON
	echo json_encode($result);
	
	mysqli_close($con);
?>