package com.lala.controller;

import com.tencent.ads.ApiContextConfig;
import com.tencent.ads.TencentAds;
import com.tencent.ads.exception.TencentAdsResponseException;
import com.tencent.ads.exception.TencentAdsSDKException;
import com.tencent.ads.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yj
 * @date 2020/12/29 下午3:26
 */
public class AddWechatPages {

    /** YOUR ACCESS TOKEN */
    public String ACCESS_TOKEN = "ba35bab1c9bada2053b18726664daefb";

    /** TencentAds */
    public TencentAds tencentAds;

    public PageElementsType elementType = PageElementsType.IMAGE;
    public String title = "YJ_TEST_TITLE";
    public PageElementsType elementType_1 = PageElementsType.IMAGE;
    public PageElementsType elementType_2 = PageElementsType.ELEMENT_TYPE_UNSUPPORTED;
    public PageElementsType elementType_3 = PageElementsType.BUTTON;
    public String title_1 = "YJ_TEST_TEXT";
    public WechatPagesAddRequest data = new WechatPagesAddRequest();
    public Long accountId = 18857854L;
    public String pageName = "YJ_TEST_TITLE_PAGE_NAME";
    public Long pageTemplateId = 1999797287L;
    public String shareTitle = "YJ_TEST_分享标题";
    public String shareDescription = "YJ_TEST_分享内容";


    public List<String> imId = Arrays.asList("331932416");

    public void init() {
        this.tencentAds = TencentAds.getInstance();
        this.tencentAds.init(
                new ApiContextConfig().accessToken(ACCESS_TOKEN).isDebug(true)); // debug==true 会打印请求详细信息
        this.tencentAds.useProduction(); // 默认使用沙箱环境，如果要请求线上，这里需要设为线上环境
        this.buildParams();
    }

    public void buildParams() {
        PageElementsStruct pageElementsStruct = new PageElementsStruct();
        pageElementsStruct.setElementType(elementType);
        GoodsButtonSpec goodsButtonSpec = new GoodsButtonSpec();
        goodsButtonSpec.setTitle(title);
        ElementImage elementImage = new ElementImage();
        elementImage.setImageIdList(imId);
        pageElementsStruct.setImageSpec(elementImage);

        PageElementsStruct pageElementsStruct_1 = new PageElementsStruct();
        pageElementsStruct_1.setElementType(elementType_1);
        ServiceSpec serviceSpec_1 = new ServiceSpec();
        serviceSpec_1.setTitle(title_1);
        ElementButtonRead buttonSpec_1 = new ElementButtonRead();
        buttonSpec_1.setServiceSpec(serviceSpec_1);
        pageElementsStruct_1.setButtonSpec(buttonSpec_1);

        PageElementsStruct pageElementsStruct_2 = new PageElementsStruct();
        pageElementsStruct_2.setElementType(elementType_2);



        List<PageElementsStruct> pageElementsSpecList = new ArrayList<>();
        pageElementsSpecList.add(pageElementsStruct);
        pageElementsSpecList.add(pageElementsStruct_1);
        pageElementsSpecList.add(pageElementsStruct_1);
        pageElementsSpecList.add(pageElementsStruct_1);
        pageElementsSpecList.add(pageElementsStruct_1);
        pageElementsSpecList.add(pageElementsStruct);
        pageElementsSpecList.add(pageElementsStruct);
        data.setPageElementsSpecList(pageElementsSpecList);

        data.setAccountId(accountId);

        data.setPageName(pageName);

        data.setPageTemplateId(pageTemplateId);

        ShareContentSpec shareContentSpec = new ShareContentSpec();
        shareContentSpec.setShareTitle(shareTitle);
        shareContentSpec.setShareDescription(shareDescription);
        data.setShareContentSpec(shareContentSpec);
    }

    public WechatPagesAddResponseData addWechatPages() throws Exception {
        WechatPagesAddResponseData response = tencentAds.wechatPages().wechatPagesAdd(data);
        return response;
    }

    public static void main(String[] args) {
        try {
            AddWechatPages addWechatPages = new AddWechatPages();
            addWechatPages.init();
            WechatPagesAddResponseData response = addWechatPages.addWechatPages();
            System.out.println(response);
        } catch (TencentAdsResponseException e) {
            e.printStackTrace();
        } catch (TencentAdsSDKException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
