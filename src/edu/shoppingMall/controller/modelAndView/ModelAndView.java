package edu.shoppingMall.controller.modelAndView;
/**
 * ����� ������ �̵���� ����
 * @author mark
 *
 */
public class ModelAndView {
    private String path;//�̵��� �� �̸�(������ �̸� = ���)
    private boolean isRedirect;//�̵����(redirect or forward) true�� �� forword, false�϶� Redirect. ����Ʈ�� false �̱� ����
    
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
