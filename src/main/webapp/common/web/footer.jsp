<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

  <div class="mobile-player">
            <div class="mobile-player__headding">
                <img src="<u:url value='template/web/assets/img/icon-home/small-logo.svg" alt="icon-home" class="mobile-player__headding-img'/>" >
                <div class="mobile-player__headding-option">
                    <span class="mobile-player__headding-option-item">ĐANG PHÁT</span>
                    <span class="mobile-player__headding-option-item">LYRIC</span>
                </div>
                <div class="mobile-player__headding-close"><i class="fas fa-times"></i></div>
            </div>
            <div class="mobile-player__body">
                <div class="mobile-player__body-thumb" style="background-image: url(template/web/assets/img/songs/0.webp);"></div>
                <div class="mobile-player__body-now">
                    <span class="mobile-player__body-now-name">Tình Yêu Ngủ Quên</span>
                    <span class="mobile-player__body-now-singer">Hoàng Tôn, LyHan, Orinn Remix</span>
                    <span class="mobile-player__body-now-extra">Remix Version</span>
                </div>
            </div>
            <div class="mobile-player__ctrl">
                <div class="music-control__center-action music-control__icon">
                    <!-- music-control__icon-random--active -->
                    <i class="fas fa-random music-control__icon1 mobile-player__ctrl-icon js__mobile-player__ctrl-icon1"></i>
                    <i class="fas fa-caret-left music-control__icon2 mobile-player__ctrl-icon js__mobile-player__ctrl-icon2"></i>
                    <!-- music-control__icon-play--active -->
                    <div class="music-control__icon-play mobile-player__ctrl-icon js__mobile-player__ctrl-icon">
                        <i class="fas fa-play music-control__icon3"></i>
                        <i class="fas fa-pause music-control__icon33"></i>
                    </div>
                    <i class="fas fa-caret-right music-control__icon4 mobile-player__ctrl-icon js__mobile-player__ctrl-icon4"></i>
                    <!-- music-control__icon-repeat--active -->
                    <i class="fas fa-redo music-control__icon5 mobile-player__ctrl-icon js__mobile-player__ctrl-icon5"></i>
                </div>
                <div class="music-control__progress mobile-player__ctrl-progress">
                    <span class="music-control__progress-time-start mobile-player__ctrl-progress-time-start">00:00</span>
                    <input id="progress2" class="music-control__progress-input mobile-player__ctrl-progress-input" type="range" value="0" step="1" min="0" max="100">
                    <span class="music-control__progress-time-duration mobile-player__ctrl-progress-time-duration">00:00</span>
                </div>
            </div>
        </div>
        
