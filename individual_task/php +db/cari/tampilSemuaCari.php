<?php 
	//Import File Koneksi Database
	require_once('koneksi.php');
	$kel_tgl_mulai = $_GET['kel_tgl_mulai'];
	$kel_tgl_akhir = $_GET['kel_tgl_akhir'];
	
	//Membuat SQL Query
	$sql = 'SELECT *, 
				MOD(TIMESTAMPDIFF(DAY, kel_tgl_mulai, kel_tgl_akhir), 12) as "hari", 
				TIMESTAMPDIFF(MONTH, kel_tgl_mulai, kel_tgl_akhir) as "bulan",
				TIMESTAMPDIFF(YEAR, kel_tgl_mulai, kel_tgl_akhir) as "tahun" 
				FROM `kelas`
				JOIN materi ON kelas.mat_id = materi.mat_id
				JOIN instruktur ON kelas.ins_id = instruktur.ins_id
				WHERE (kel_tgl_mulai BETWEEN "'.$kel_tgl_mulai.'" AND "'.$kel_tgl_akhir.'");';
			//Mendapatkan Hasil
	$r = mysqli_query($con,$sql);
	//Membuat Array Kosong 
	$result = array();
	
	while($row = mysqli_fetch_array($r)){
		//Memasukkan Nama dan ID kedalam Array Kosong yang telah dibuat 
		array_push($result,array(
			"id"=>$row['kel_id'],
			"kel_tgl_mulai"=>$row['kel_tgl_mulai'],
			"kel_tgl_akhir"=>$row['kel_tgl_akhir'],
			"mat_nama"=>$row['mat_nama'],
			"ins_nama"=>$row['ins_nama'],
			"ins_kontak" => $row['ins_hp']." - ".$row['ins_email'],
			"hari" => $row['hari'],
			"bulan" => $row['bulan'],
			"tahun" => $row['tahun'],

		));
	}
	
	//Menampilkan Array dalam Format JSON
	echo json_encode($result);
	
	mysqli_close($con);
?>