<?php 
	//Mendapatkan Nilai Dari Variable ID Pegawai yang ingin ditampilkan
	$id = $_GET['id'];
	
	//Importing database
	require_once('koneksi.php');
	
	//Membuat SQL Query dengan pegawai yang ditentukan secara spesifik sesuai ID
	$sql = "SELECT * FROM `kelas`
	JOIN instruktur ON kelas.ins_id = instruktur.ins_id
    JOIN materi ON kelas.mat_id = materi.mat_id 
	WHERE kel_id=$id";
	
	//Mendapatkan Hasil 
	$r = mysqli_query($con,$sql);
	
	//Memasukkan Hasil Kedalam Array
	$result = array();
	$row = mysqli_fetch_array($r);
	array_push($result,array(
			"id"=>$row['kel_id'],
			"date_mulai" => $row['kel_tgl_mulai'],
			"date_akhir" => $row['kel_tgl_akhir'],
			"id_ins" => $row['ins_id'],
			"name_instruktur"=>$row['ins_nama'],
			"ins_hp"=>$row['ins_hp'],
			"ins_email"=>$row['ins_email'],
			"id_mat"=>$row['mat_id'],
			"name_materi"=>$row['mat_nama'],
		));

	//Menampilkan dalam format JSON
	echo json_encode($result);
	
	mysqli_close($con);
?>