<?php 
	//Import File Koneksi Database
	require_once('koneksi.php');
    $id = $_GET['id'];
	
	//Membuat SQL Query
	$sql = "SELECT * FROM `detail_kelas` 
	JOIN kelas ON detail_kelas.kel_id = kelas.kel_id 
	JOIN peserta ON detail_kelas.pes_id = peserta.pes_id 
	JOIN instruktur ON kelas.ins_id = instruktur.ins_id 
	JOIN materi ON kelas.mat_id = materi.mat_id
	WHERE detail_kelas.kel_id='$id'
	ORDER BY detail_kelas.kel_id;";
	
	function KonversiTanggal($tanggal) {
		$date = date('d-m-Y', strtotime($tanggal));
		return $date;
	};

	//Mendapatkan Hasil
	$r = mysqli_query($con,$sql);
	
	//Membuat Array Kosong 
	$result = array();
	$no = 0;
	while($row = mysqli_fetch_array($r)){
		$date_kelas = KonversiTanggal($row['kel_tgl_mulai'])." - ".KonversiTanggal($row['kel_tgl_akhir']);
		$no ++;
		//Memasukkan Nama dan ID kedalam Array Kosong yang telah dibuat 
		array_push($result,array(
			"no" => "$no",
			"mat_nama" => $row['mat_nama'],
			"kel_id" => $row['kel_id'],
			"det_kel_id" => $row['det_kel_id'],
			"ins_nama" => $row['ins_nama'],
			"ins_kontak" => $row['ins_hp']. " / ".$row['ins_email'],
			"date_kelas" => $date_kelas,
			"pes_id" => $row['pes_id'],
			"pes_nama" => $row['pes_nama'],
			"pes_kontak" => $row['pes_hp']." / ".$row['pes_email']
		));
	}
	
	//Menampilkan Array dalam Format JSON
	echo json_encode($result);
	
	mysqli_close($con);
?>