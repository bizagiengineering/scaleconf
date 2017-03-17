package scaleconf.model;

/**
 * Created by dev-camiloh on 3/7/17.
 */
public class Holder {

    private String name;
    private String email;
    private String profileUrl;
    private String documentUrl;
    private Integer code;

    public Holder(){}

    public Holder(String name,String email, String profileUrl, String documentUrl,Integer code) {
        this.name = name;
        this.email=email;
        this.profileUrl = profileUrl;
        this.documentUrl = documentUrl;
        this.code=code;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public String getDocumentUrl() {
        return documentUrl;
    }

    public Integer getCode() {
        return code;
    }
}
