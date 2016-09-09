<%@ page isELIgnored="false"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:set var="mySelf" value="${pageContext.request.userPrincipal.name}" scope="session"/>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<!--  Slider   -->


<div class="container">
			<section>
				<div class="page-header" id="gallery">
					
				</div>

				<div class="carousel slide" id="screenshot-carousel"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#screenshot-carousel" data-slide-to="0"
							class="active"></li>
						<li data-target="#screenshot-carousel" data-slide-to="1"></li>
						<li data-target="#screenshot-carousel" data-slide-to="2"></li>
						<li data-target="#screenshot-carousel" data-slide-to="3"></li>
					</ol>
					<div class="carousel-inner">
						<div class="item active">
							<img src="resources/images/i1.jpg" alt="" width="40%">
							<div class="carousel-caption">
								<h5></h5>
								
							</div>
						</div>
						<div class="item">
							<img src="resources/images/i5.jpg" alt="" width="40%">
							<div class="carousel-caption">
								<h5></h5>
								
							</div>
						</div>
						<div class="item">
							<img src="resources/images/i10.jpg" alt="" width="40%">
							<div class="carousel-caption">
								<h5></h5>
		
							</div>
						</div>
						<div class="item">
							<img src="resources/images/i8.jpg" alt="" width=""40%"">
							<div class="carousel-caption">
								<h5></h5>
								
							</div>
						</div>

					</div>
					<!-- End Carousel inner -->
					<a href="#screenshot-carousel" class="left carousel-control"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span>
					</a> <a href="#screenshot-carousel" class="right carousel-control"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span>
					</a>
				</div>
				<!-- End Carousel -->

			</section>
		</div>

<!--  content -->
	


<div class="row">
            <div class="col-sm-6 col-md-4 col-lg-2">
                <h2>HTML</h2>
                <p>HTML is a markup language that is used for creating web pages. The HTML tutorial section will help you understand the basics of HTML, so that you can create your own web pages or website.</p>
                <p><a href="" target="_blank" class="btn btn-success">Learn More &raquo;</a></p>
            </div>
            <div class="col-sm-6 col-md-4 col-lg-2">
                <h2>CSS</h2>
                <p>CSS is used for describing the presentation of web pages. The CSS tutorial section will help you learn the essentials of CSS, so that you can fine control the style and layout of your HTML document.</p>
                <p><a href="" target="_blank" class="btn btn-success">Learn More &raquo;</a></p>
            </div>
            <div class="clearfix visible-sm-block"></div>
            <div class="col-sm-6 col-md-4 col-lg-2">
                <h2>Bootstrap</h2>
                <p>Bootstrap is a powerful front-end framework for faster and easier web development. The Bootstrap tutorial section will help you learn the techniques of Bootstrap so that you can create web your own website with much less efforts.</p>
                <p><a href="" target="_blank" class="btn btn-success">Learn More &raquo;</a></p>
            </div>
            <div class="clearfix visible-md-block"></div>
            <div class="col-sm-6 col-md-4 col-lg-2">
                <h2>References</h2>
                <p>The references section outlines all the standard HTML tags and CSS properties along with other useful references such as color names and values, symbols and character entities, web safe fonts, language codes, HTTP messages and much more.</p>
                <p><a href="" target="_blank" class="btn btn-success">Learn More &raquo;</a></p>
            </div>
            <div class="clearfix visible-sm-block"></div>
            <div class="col-sm-6 col-md-4 col-lg-2">
                <h2>Examples</h2>
                <p>The examples section encloses an extensive collection of examples on various topic that you can try and test yourself using online HTML editor.</p>
                <p><a href="" target="_blank" class="btn btn-success">Learn More &raquo;</a></p>
            </div>
            <div class="col-sm-6 col-md-4 col-lg-2">
                <h2>FAQ</h2>
                <p>The collection of Frequently Asked Questions (FAQ) provides brief answers to many common questions related to web design and development.</p>
                <p><a href="" target="_blank" class="btn btn-success">Learn More &raquo;</a></p>
            </div>
        </div>
	</tiles:putAttribute>
</tiles:insertDefinition>
