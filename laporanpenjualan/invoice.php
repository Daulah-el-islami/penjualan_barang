<?php 
    include "config/koneksi.php";
?>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>FAKTUR PENJUALAN</title>
    
    <link rel="stylesheet" type="text/css" href="css/invoice.css">
</head>

<body onload="window.print()">

    <div class="invoice-box">
        <table cellpadding="0" cellspacing="0">
            <tr class="top">
                <td colspan="5">
                    <table>
                        <tr>
                            <td class="title">
                                <p style="font-size: 20px;">PENJUALAN BARANG</p>
                            </td>
                            
                            <td>
                               <?php
                               $tanggal=date('Y-m-d');
                               echo $tanggal;
                               ?>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            
            <tr class="information">
                <td colspan="5">
                    <table>
                        <tr>
                            <td>
                                Jalan Siliwangi<br>
                                Kp.Kiansantang Ds.Lingga Buana<br>
                                Kec.Niskala -Kab.Maharaja
                            </td>
                            
                            <td>
                                PT PRABU<br>
                                wwww.prabusiliwangi.com<br>
                                kiansantang@prabu.com
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            
            <tr class="nofaktur">
                <td>
                    NO FAKTUR
                </td>
                
                <td>
                    <?php echo $_GET['fk'] ?>
                </td>
            </tr>
            
            <tr class="details">
                <td colspan="2"></td>
            </tr>
            
            <tr class="heading">
                <td>NO</td>
                <td>Nama Barang</td>
                <td>Harga Satuan</td>
                <td>Quantity</td>
                <td>Total Harga</td>
            </tr>
            <?php 
                $no=0;
                $a = mysqli_query($con,"SELECT * FROM tbl_penjualan WHERE nofaktur = '$_GET[fk]'");
                while($r=mysqli_fetch_array($a)){
                $no++;
            ?>
            <tr class="item">
                <td><?php echo $no ?></td>
                <td><?php echo $r['nama_barang'] ?></td>
                <td><?php echo number_format($r['hsatuan'], 0, ',', '.') ?></td>
                <td><?php echo $r['jumlah_jual'] ?></td>
                <td><?php echo number_format($r['harga'], 0, ',', '.') ?></td>
            </tr>
            <?php } ?>
            
            <tr class="details">
                <td colspan="5"></td>
            </tr>
            
            <tr class="total">
                <td colspan="3"></td>
                <th align="right">Grand Total :</th>
                <?php
                $a = mysqli_query($con, "SELECT SUM(harga) as TOTAL FROM tbl_penjualan WHERE nofaktur='$_GET[fk]'");
                $total = mysqli_fetch_array($a);
                ?>
                <td><?php echo number_format($total['TOTAL'], 0, ',', '.') ?></td>
            </tr>
            <tr class="total">
                <td colspan="3"></td>
                <th align="right">Bayar :</th>
                <?php
                $b = mysqli_query($con, "SELECT bayar FROM tbl_penjualan WHERE nofaktur='$_GET[fk]'");
                $bayar = mysqli_fetch_array($b);
                ?>
                <td><?php echo number_format($bayar['bayar'], 0, ',', '.') ?></td>
            </tr>
            <tr class="total">
                <td colspan="3"></td>
                <th align="right">Kembalian :</th>
                <?php
                $c = mysqli_query($con, "SELECT kembalian FROM tbl_penjualan WHERE nofaktur='$_GET[fk]'");
                $kembalian = mysqli_fetch_array($c);
                ?>
                <td><?php echo number_format($kembalian['kembalian'], 0, ',', '.') ?></td>
            </tr>
        </table>
    </div>
</body>
</html>
