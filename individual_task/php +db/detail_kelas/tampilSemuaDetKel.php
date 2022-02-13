<?php 
	//Import File Koneksi Database
	require_once('koneksi.php');
	
	//Membuat SQL Query
	$sql = "SELECT COUNT(*) as 'jml_pes', detail_kelas.kel_id, 
				materi.mat_nama, kelas.kel_tgl_mulai, kelas.kel_tgl_akhir,
				instruktur.ins_nama
				FROM `detail_kelas`
					JOIN kelas ON detail_kelas.kel_id = kelas.kel_id
					JOIN materi ON kelas.mat_id = materi.mat_id
					JOIN instruktur ON kelas.ins_id = instruktur.ins_id
				GROUP BY detail_kelas.kel_id;";
	
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
			"kel_id" => $row['kel_id'],
			"mat_nama" => $row['mat_nama'],
			"ins_nama" => $row['ins_nama'],
			"jml_pes" => $row['jml_pes'],
			"date_kelas" => $date_kelas,
		));
	}
	
	//Menampilkan Array dalam Format JSON
	echo json_encode($result);
	
	mysqli_close($con);
?>