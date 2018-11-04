package edu.shoppingMall.controller.modelAndView;
/**
 * 결과뷰 정보와 이동방식 설정
 * @author mark
 *
 */
public class ModelAndView {
    private String path;//이동할 뷰 이름(페이지 이름 = 경로)
    private boolean isRedirect;//이동방식(redirect or forward) true일 떄 forword, false일때 Redirect. 디폴트가 false 이기 때문
    
    public String getPath() {
        return path;
    }
    public boolean isRedirect() {
        return isRedirect;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public void setRedirect(boolean isRedirect) {
        this.isRedirect = isRedirect;
    }
    
    
}
