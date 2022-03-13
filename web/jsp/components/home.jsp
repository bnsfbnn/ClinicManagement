<%-- 
    Document   : home
    Created on : Feb 23, 2022, 8:15:14 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <style>
        .content{
            background-image: url("https://isofhcare.com/_next/static/banner.png");
            height: 482px;
            text-align: center;
            padding-top: 160px;
        }
        .content input{
            width: 700px;
            height: 50px;
            boder:3px;
            border-color: #00ba99;
            border-style: solid;
            border-radius: 10px;
            padding:10px;
            text-color:#00ba99;
        }
        .card{
            padding:20px;
        }
        .container-fluid img{
            border-radius: 50%;
            width: 140px;
            height: 140px;
            margin: 0 auto;
        }
        .card{
            text-align: center;
        }
        h5{
            margin-left: 45px;
            

        }
        .content-page img{
            width: 100%;
            margin-top: 20px;
        }
        .content-infor{
            margin-left: 200px;
            margin-right: 200px;

        }
        .col-4 img{
            height: 400px;
        }
        
    </style>
    <jsp:include page="../components/header.jsp" />

    <body>

        <div class="content text-white ">
                <h2>Tìm bác sĩ, bệnh viện dễ dàng hơn</h2>
                <p>Chủ động đặt lịch hẹn thông minh và được chăm sóc tận tình</p>
                <input type="text" placeholder="Nhập tên bác sĩ, bệnh viện, dịch vụ">
        </div>
        <div class="container-fluid mt-3">
            <div>
                <h5 >Dịch vụ của chúng tôi</h5>
            </div>
            <div class="d-flex justify-content-around mt-3">
            <div class="card" style="width: 18rem;">
  <img class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si_02156a3d_6d43_476f_8d12_7d10e6d3795e.png" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">Bác sĩ</h5>
    <p class="card-text">Đặt khám trực tiếp tới đội ngũ bác sĩ của ISOFHCARE có trình độ chuyên môn cao, nhiều năm kinh nghiệm, giàu y đức, giúp bạn hoàn toàn chủ động lựa chọn thời gian khám.</p>
  </div>
</div>
              <div class="card" style="width: 18rem;">
  <img class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/benh-vien_3af5757b_be9b_4a39_9948_6d2062b72316.png" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">Bệnh viện</h5>
    <p class="card-text">Đặt khám theo gói dịch vụ chất lượng, dịch vụ xét nghiệm và chẩn đoán hình ảnh hiện đại tới từ các đối tác bệnh viện hàng đầu, tuyến Trung Ương của ISOFHCARE.</p>
  </div>
</div>
              <div class="card" style="width: 18rem;">
  <img class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/cam-nang_9ec6df99_ba08_4015_b679_2459308c5e26.png" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">Cẩm nang</h5>
    <p class="card-text">Với lượng bài đăng phong phú, chuyên mục Cẩm nang y tế cung cấp cho bạn nhiều kiến thức bổ ích về sức khỏe, mang tính thực tiễn áp dụng vào.</p>
  </div>
</div>
              <div class="card" style="width: 18rem;">
  <img class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/cong-dong_15c2ee3e_0448_4635_ac97_645a84969848.png" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">Cộng đồng</h5>
    <p class="card-text">Cộng đồng y tế đông đảo với sự tham gia của các bác sĩ đầu ngành tới từ nhiều lĩnh vực, hỗ trợ giải đáp các thắc mắc của bạn trong mọi khía cạnh sức khỏe.</p>
  </div>
</div>
                <div class="card" style="width: 18rem;">
  <img class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si_02156a3d_6d43_476f_8d12_7d10e6d3795e.png" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">Bác sĩ</h5>
    <p class="card-text">Đặt khám trực tiếp tới đội ngũ bác sĩ của ISOFHCARE có trình độ chuyên môn cao, nhiều năm kinh nghiệm, giàu y đức, giúp bạn hoàn toàn chủ động lựa chọn thời gian khám.</p>
  </div>
</div>
                </div>
        </div>
        <div class="content-page">
            <img src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/kit-test-nhanh-covid-tai-nha-isofhcare-jpg_99fa2328_f5d7_4eb8_8561_ae5a4c49c9be.png"
            
        </div>
        <div class="content-infor mt-5">
            <div class="row container-fluid">
                <div class="col-4">
                    <p class="font-weight-bold">Bác sĩ nổi bật</p>
                    <br>
                    <p>Đặt khám trực tiếp tới đội ngũ bác sĩ của ISOFHCARE có trình độ chuyên môn cao, nhiều năm kinh nghiệm, giàu y đức, giúp bạn hoàn toàn chủ động lựa chọn thời gian khám</p>
                    <img src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si-noi-bat_3aafb5a5_e84b_4be0_bf87_4689b981e5d7.png">
                </div>
                <div class="col-8 d-flex justify-content-around">
                    <div class="card" style="width: 18rem;">
  <img class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si_02156a3d_6d43_476f_8d12_7d10e6d3795e.png" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">Bác sĩ</h5>
    <p class="card-text">Đặt khám trực tiếp tới đội ngũ bác sĩ của ISOFHCARE có trình độ chuyên môn cao, nhiều năm kinh nghiệm, giàu y đức, giúp bạn hoàn toàn chủ động lựa chọn thời gian khám.</p>
  </div>
</div>
                    <div class="card" style="width: 18rem;">
  <img class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si_02156a3d_6d43_476f_8d12_7d10e6d3795e.png" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">Bác sĩ</h5>
    <p class="card-text">Đặt khám trực tiếp tới đội ngũ bác sĩ của ISOFHCARE có trình độ chuyên môn cao, nhiều năm kinh nghiệm, giàu y đức, giúp bạn hoàn toàn chủ động lựa chọn thời gian khám.</p>
  </div>
</div>
                    <div class="card" style="width: 18rem;">
  <img class="card-img-top" src="https://isofhcare-backup.s3-ap-southeast-1.amazonaws.com/images/bac-si_02156a3d_6d43_476f_8d12_7d10e6d3795e.png" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">Bác sĩ</h5>
    <p class="card-text">Đặt khám trực tiếp tới đội ngũ bác sĩ của ISOFHCARE có trình độ chuyên môn cao, nhiều năm kinh nghiệm, giàu y đức, giúp bạn hoàn toàn chủ động lựa chọn thời gian khám.</p>
  </div>
</div>
                </div>
                
            </div>
        </div>
        
    </body>
</html>
