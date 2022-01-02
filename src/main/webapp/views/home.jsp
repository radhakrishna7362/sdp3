<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>FeelHome</title>
  <meta content="" name="description">
  <meta content="" name="keywords">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
  <link
    href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
    rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
  <link href="assets/css/style.css" rel="stylesheet">
</head>

<body>
  <header id="header" class="fixed-top d-flex align-items-center">
    <div class="container d-flex align-items-center">

      <div class="logo me-auto">
        <h1><a href="/">FeelHome</a></h1>
      </div>

      <nav id="navbar" class="navbar order-last order-lg-0">
        <ul>
          <li><a class="nav-link scrollto active" href="#hero">Home</a></li>
          <li><a class="nav-link scrollto" href="#about">About</a></li>
          <li class="dropdown"><a href="#"><span class="butjo">Join Now<i class="bi bi-chevron-down"></i></span></a>
            <ul>
              <li class="dropdown"><a href="#"><span>For Traveller</span> <i class="bi bi-chevron-right"></i></a>
                <ul>
                  <li><a href="/login">Login</a></li>
                  <li><a href="/register">Register</a></li>
                </ul>
              </li>
              <li class="dropdown"><a href="#"><span>For GuestHouse Provider</span> <i
                    class="bi bi-chevron-right"></i></a>
                <ul>
                  <li><a href="/guest-provider-login">Login</a></li>
                  <li><a href="/guest-provider-register">Register</a></li>
                </ul>
              </li>
              <li class="dropdown"><a href="#"><span>For Admin</span> <i class="bi bi-chevron-right"></i></a>
                <ul>
                  <li><a href="/admin-login">Login</a></li>
                </ul>
              </li>
            </ul>
          </li>
          <li><a class="nav-link scrollto" href="#contact">Contact</a></li>
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->

      <div class="header-social-links d-flex align-items-center">
        <a href="#" class="twitter"><i class="bi bi-twitter"></i></a>
        <a href="#" class="facebook"><i class="bi bi-facebook"></i></a>
        <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
        <a href="#" class="linkedin"><i class="bi bi-linkedin"></i></i></a>
      </div>

    </div>
  </header>
  <section id="hero" class="d-flex flex-column justify-content-center align-items-center">
    <div class="container text-center text-md-left" data-aos="fade-up">
      <h1>Welcome to <span>FeelHome</span></h1>
      <h2>We're here to assist you.</h2>
      <a href="#about" class="btn-get-started scrollto">Get Started</a>
    </div>
  </section>

  <main id="main">
    <section id="what-we-do" class="what-we-do">
      <div class="container">
        <div class="section-title">
          <h2>What We Do</h2>
          <p>We assist travellers to find homely experience during their stops while enrouting themselves to their
            destination.</p>
        </div>
      </div>
    </section>
    <section id="about" class="about">
      <div class="container">

        <div class="row">
          <div class="col-lg-6">
            <img src="assets/img/about.jpg" class="img-fluid" alt="">
          </div>
          <div class="col-lg-6 pt-4 pt-lg-0">
            <h3>About Us</h3>
            <p>
              The homestay culture in the world is still unknown to many people and our aim with <b>FEELHOME</b> is to
              realize people what is homestay and how the experience homestay provides.
            </p>
            <br>
            <br>
            <ul>
              <li><i class="bx bx-check-double"></i> Travellers can able to experience the culture that the local people
                practice and also have a homely experience during their stay.</li>
              <li><i class="bx bx-check-double"></i> GuestHouse Providers can be able to showcase their exquisite
                culture pratices to the travellers who visited them for the stay.</li>
            </ul>
          </div>
        </div>

      </div>
    </section>
    <br>
    <section id="counts" class="counts">
      <div class="container">

        <div class="row justify-content-center">

          <div class="col-lg-3 col-6">
            <div class="count-box">
              <i class="bi bi-emoji-smile"></i>
              <span data-purecounter-start="0" data-purecounter-end="${noOfProviders }" data-purecounter-duration="1"
                class="purecounter"></span>
              <p>No of Guest House Providers</p>
            </div>
          </div>

          <div class="col-lg-3 col-6">
            <div class="count-box">
              <i class="bi bi-journal-richtext"></i>
              <span data-purecounter-start="0" data-purecounter-end="${noOfHouses }" data-purecounter-duration="1"
                class="purecounter"></span>
              <p>No of Guest Houses</p>
            </div>
          </div>

          <div class="col-lg-3 col-6 mt-5 mt-lg-0">
            <div class="count-box">
              <i class="bi bi-person"></i>
              <span data-purecounter-start="0" data-purecounter-end="${noOfUsers }" data-purecounter-duration="1"
                class="purecounter"></span>
              <p>Registered Travellers</p>
            </div>
          </div>

        </div>

      </div>
    </section><!-- End Counts Section -->
    <!-- ======= Contact Section ======= -->
    <section id="contact" class="contact section-bg">
      <div class="container">

        <div class="section-title">
          <h2>Contact</h2>
          <p>Always be welcome to ask any type of questions</p>
        </div>

        <div class="row mt-5 justify-content-center">

          <div class="col-lg-10">

            <div class="info-wrap">
              <div class="row">
                <div class="col-lg-4 info">
                  <i class="bi bi-geo-alt"></i>
                  <h4>Location:</h4>
                  <p>KL University<br>Vijayawada, AndhraPradesh 522502</p>
                </div>

                <div class="col-lg-4 info mt-4 mt-lg-0">
                  <i class="bi bi-envelope"></i>
                  <h4>Email:</h4>
                  <p>dharshith3110@gmail.com<br>7krishna3radha@gmail.com</p>
                </div>

                <div class="col-lg-4 info mt-4 mt-lg-0">
                  <i class="bi bi-phone"></i>
                  <h4>Call:</h4>
                  <p>+91 6309124310<br>+91 7569468733</p>
                </div>
              </div>
            </div>

          </div>

        </div>

      </div>
    </section><!-- End Contact Section -->
	<footer id="footer" class="mb-2">
	    <div class="container mb-2">
	      <div class="me-md-auto text-center">
	        <div class="copyright">
	          Copyright &copy; 2021
	          <a href="." class="link-secondary">FeelHome</a>.
	          All rights reserved.
	        </div>
	      </div>
	    </div>
	    <div class="social-links text-center text-md-right pt-3 pt-md-0">
	      <a href="#" class="twitter"><i class="bx bxl-twitter"></i></a>
	      <a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
	      <a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
	      <a href="#" class="google-plus"><i class="bx bxl-skype"></i></a>
	      <a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
	    </div>
	    </div>
	  </footer>
  </main><!-- End #main -->

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
      class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/purecounter/purecounter.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="assets/vendor/waypoints/noframework.waypoints.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

</body>
</html>