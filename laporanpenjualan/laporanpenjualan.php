<?php 
  include "config/koneksi.php";

  $where = "";
  if(isset($_POST['cek'])){
      $where = "WHERE tanggal BETWEEN '$_POST[dari]' AND '$_POST[sampai]'";
  }
?>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>LAPORAN PENJUALAN</title>
    <style>
      @media print {
        .no-print {
          display: none;
        }
      }
    </style>
  </head>
  <body>
    <div class="container">
      <div class="row">
        <div class="col-md-12"><h1 class="text-center text-primary">LAPORAN PENJUALAN BARANG</h1>
          <?php
          $tanggal = date('d-M-Y');
          echo $tanggal;
          ?>
        </div>
        <div class="col-md-4">
          <h3> </h3>
        </div>
      </div>
      <div class="row no-print">
        <div class="col-md-12">
          <form method="post">
            <table>
              <tr>
                <td>Dari Tanggal <input type="date" name="dari"></td>
                <td>   Sampai <input type="date" name="sampai"></td>
                <td><input type="submit" name="cek" value="CEK"></td>
                <td style="padding-left: 580px;"><a href="javascript:void(0);" onclick="window.print()" target="_blank" class="no-print"><img src="img/print.jpg" alt="print" class="img-thumbnail" height="20" width="40" style="margin-top:5px"></a></td>
              </tr>
            </table>
          </form>
        </div>
      </div>
      <br>
      <div class="row">
        <div class="col-md-12">
          <table class="table">
            <thead class="thead-dark">
              <tr>
                <th>No Faktur</th>
                <th>Kode Barang</th>
                <th>Nama Barang</th>
                <th>Harga Satuan</th>
                <th>Jumlah Beli</th>
                <th>Total</th>
                <th>Tanggal</th>
              </tr>
            </thead>
            <tbody>
              <?php 
                $sql = "SELECT * FROM tbl_penjualan $where";
                $query = mysqli_query($con, $sql);
                if($query){
                  while($r= mysqli_fetch_array($query)){
              ?>
              <tr>
                <td><?php echo $r['nofaktur'] ?></td>
                <td><?php echo $r['kode_barang'] ?></td>
                <td><?php echo $r['nama_barang'] ?></td>
                <td><?php echo $r['hsatuan'] ?></td>
                <td><?php echo $r['jumlah_jual'] ?></td>
                <td><?php echo $r['harga'] ?></td>
                <td><?php echo $r['tanggal'] ?></td>
              </tr>
              <?php 
                  }
                } else {
                  echo "<tr><td colspan='7'>Data tidak ditemukan</td></tr>";
                }
              ?>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>