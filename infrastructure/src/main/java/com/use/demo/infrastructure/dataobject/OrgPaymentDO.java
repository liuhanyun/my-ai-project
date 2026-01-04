package com.use.demo.infrastructure.dataobject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrgPaymentDO {
    private Integer id;
    private String paymentUid;
    private String previousPaymentUid;
    private String ownerPaymentUid;
    private String payCode;
    private String payName;
    private String payType;
    private Boolean isActive;
    private Boolean isOwnerActive;
    private Boolean isArchived;
    private String revenueType;
    private Boolean incomeCanBeInvoiced;
    private String appliedChannels;
    private String paymentChannel;
    private Boolean isDiscountReasonRequired;
    private String financialAccount;
    private Integer sourceType;
    private Boolean isDelete;
    private String payExtendType;
    private String dataId;
    private Long payTypeId;
    private String paymentMethod;
    private String paymentMethodSubtype;
    private String unSupportBizType;
    private Boolean openDrawer;
    private Long seq;
    private String platformCode;
    private String platformPaymentUid;
    private String payIcon;
    private String subParameters;
    private String revenueRules;

}


