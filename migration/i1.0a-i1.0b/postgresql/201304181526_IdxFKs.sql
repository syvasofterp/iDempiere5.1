CREATE UNIQUE INDEX m_packagemps_uu_idx ON m_packagemps (m_packagemps_uu)
;

CREATE UNIQUE INDEX c_depositbatch_uu_idx ON c_depositbatch (c_depositbatch_uu)
;

CREATE UNIQUE INDEX c_1099box_uu_idx ON c_1099box (c_1099box_uu)
;

CREATE UNIQUE INDEX c_onlinetrxhistory_uu_idx ON c_onlinetrxhistory (c_onlinetrxhistory_uu)
;

CREATE UNIQUE INDEX m_shippingprocessorcfg_uu_idx ON m_shippingprocessorcfg (m_shippingprocessorcfg_uu)
;

CREATE UNIQUE INDEX t_1099extract_uu_idx ON t_1099extract (t_1099extract_uu)
;

CREATE UNIQUE INDEX m_shipperpackaging_uu_idx ON m_shipperpackaging (m_shipperpackaging_uu)
;

CREATE UNIQUE INDEX m_shippingtransactionli_uu_idx ON m_shippingtransactionline (m_shippingtransactionline_uu)
;

CREATE UNIQUE INDEX m_shippercfg_uu_idx ON m_shippercfg (m_shippercfg_uu)
;

CREATE UNIQUE INDEX m_rmatax_uu_idx ON m_rmatax (m_rmatax_uu)
;

CREATE UNIQUE INDEX m_shipperpickuptypescfg_uu_idx ON m_shipperpickuptypescfg (m_shipperpickuptypescfg_uu)
;

CREATE UNIQUE INDEX ad_storageprovider_uu_idx ON ad_storageprovider (ad_storageprovider_uu)
;

CREATE UNIQUE INDEX ws_webservice_para_uu_idx ON ws_webservice_para (ws_webservice_para_uu)
;

CREATE UNIQUE INDEX ws_webservicefieldoutpu_uu_idx ON ws_webservicefieldoutput (ws_webservicefieldoutput_uu)
;

CREATE UNIQUE INDEX ad_ctxhelpmsg_trl_uu_idx ON ad_ctxhelpmsg_trl (ad_ctxhelpmsg_trl_uu)
;

CREATE UNIQUE INDEX c_depositbatchline_uu_idx ON c_depositbatchline (c_depositbatchline_uu)
;

CREATE UNIQUE INDEX m_shippingprocessor_uu_idx ON m_shippingprocessor (m_shippingprocessor_uu)
;

CREATE UNIQUE INDEX c_paymenttransaction_uu_idx ON c_paymenttransaction (c_paymenttransaction_uu)
;

CREATE UNIQUE INDEX m_commodityshipment_uu_idx ON m_commodityshipment (m_commodityshipment_uu)
;

CREATE UNIQUE INDEX ws_webservicetypeaccess_uu_idx ON ws_webservicetypeaccess (ws_webservicetypeaccess_uu)
;

CREATE UNIQUE INDEX ad_ctxhelp_uu_idx ON ad_ctxhelp (ad_ctxhelp_uu)
;

CREATE UNIQUE INDEX ws_webservicetype_uu_idx ON ws_webservicetype (ws_webservicetype_uu)
;

CREATE UNIQUE INDEX m_shipperpackagingcfg_uu_idx ON m_shipperpackagingcfg (m_shipperpackagingcfg_uu)
;

CREATE UNIQUE INDEX c_bp_shippingacct_uu_idx ON c_bp_shippingacct (c_bp_shippingacct_uu)
;

CREATE UNIQUE INDEX m_shipperlabels_uu_idx ON m_shipperlabels (m_shipperlabels_uu)
;

CREATE UNIQUE INDEX m_shipperlabelscfg_uu_idx ON m_shipperlabelscfg (m_shipperlabelscfg_uu)
;

CREATE UNIQUE INDEX m_shipperpickuptypes_uu_idx ON m_shipperpickuptypes (m_shipperpickuptypes_uu)
;

CREATE UNIQUE INDEX m_shippingtransaction_uu_idx ON m_shippingtransaction (m_shippingtransaction_uu)
;

CREATE UNIQUE INDEX ad_broadcastmessage_uu_idx ON ad_broadcastmessage (ad_broadcastmessage_uu)
;

CREATE UNIQUE INDEX ws_webservicefieldinput_uu_idx ON ws_webservicefieldinput (ws_webservicefieldinput_uu)
;

CREATE UNIQUE INDEX ad_ctxhelpmsg_uu_idx ON ad_ctxhelpmsg (ad_ctxhelpmsg_uu)
;

CREATE UNIQUE INDEX ad_infowindow_access_uu_idx ON ad_infowindow_access (ad_infowindow_access_uu)
;

ALTER TABLE AD_BroadcastMessage ADD CONSTRAINT NotificationClient_ADBroadcast FOREIGN KEY (Notification_Client_ID) REFERENCES AD_Client DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE AD_BroadcastMessage ADD CONSTRAINT ADRole_ADBroadcastMessage FOREIGN KEY (AD_Role_ID) REFERENCES AD_Role DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE AD_BroadcastMessage ADD CONSTRAINT ADUser_ADBroadcastMessage FOREIGN KEY (AD_User_ID) REFERENCES AD_User DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE ad_storageprovider ADD CONSTRAINT ad_storageprovider_pkey PRIMARY KEY (ad_storageprovider_id)
;

ALTER TABLE AD_ClientInfo ADD CONSTRAINT ADStorageProvider_ADClientInfo FOREIGN KEY (AD_StorageProvider_ID) REFERENCES AD_StorageProvider DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE AD_ClientInfo ADD CONSTRAINT StorageArchive_ADClientInfo FOREIGN KEY (StorageArchive_ID) REFERENCES AD_StorageProvider DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE AD_ClientInfo ADD CONSTRAINT CChargeFreight_ADClientInfo FOREIGN KEY (C_ChargeFreight_ID) REFERENCES C_Charge DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE AD_CtxHelpMsg ADD CONSTRAINT ADCtxHelp_ADCtxHelpMsg FOREIGN KEY (AD_CtxHelp_ID) REFERENCES AD_CtxHelp DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE AD_CtxHelpMsg_Trl ADD CONSTRAINT ADCtxHelpMsg_ADCtxHelpMsgTrl FOREIGN KEY (AD_CtxHelpMsg_ID) REFERENCES AD_CtxHelpMsg DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE AD_CtxHelpMsg_Trl ADD CONSTRAINT ADLangu_ADCtxHelpMsgTrl FOREIGN KEY (AD_Language) REFERENCES AD_Language DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE AD_Form ADD CONSTRAINT ADCtxHelp_ADForm FOREIGN KEY (AD_CtxHelp_ID) REFERENCES AD_CtxHelp DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE AD_InfoColumn ADD CONSTRAINT ADReferenceValue_ADInfoColumn FOREIGN KEY (AD_Reference_Value_ID) REFERENCES AD_Reference DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE AD_InfoColumn ADD CONSTRAINT ADValRule_ADInfoColumn FOREIGN KEY (AD_Val_Rule_ID) REFERENCES AD_Val_Rule DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE AD_InfoWindow ADD CONSTRAINT ADCtxHelp_ADInfoWindow FOREIGN KEY (AD_CtxHelp_ID) REFERENCES AD_CtxHelp DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE AD_InfoWindow_Access ADD CONSTRAINT ADInfoWindow_ADInfoWindowAcces FOREIGN KEY (AD_InfoWindow_ID) REFERENCES AD_InfoWindow DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE AD_InfoWindow_Access ADD CONSTRAINT ADRole_ADInfoWindowAccess FOREIGN KEY (AD_Role_ID) REFERENCES AD_Role DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE AD_Language ADD CONSTRAINT ADPrintPaper_ADLanguage FOREIGN KEY (AD_PrintPaper_ID) REFERENCES AD_PrintPaper DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE AD_Menu ADD CONSTRAINT ADInfoWindow_ADMenu FOREIGN KEY (AD_InfoWindow_ID) REFERENCES AD_InfoWindow DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE AD_Note ADD CONSTRAINT ADBroadcastMessage_ADNote FOREIGN KEY (AD_BroadcastMessage_ID) REFERENCES AD_BroadcastMessage DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE AD_Package_Exp_Detail ADD CONSTRAINT ADValRule_ADPackageExpDetail FOREIGN KEY (AD_Val_Rule_ID) REFERENCES AD_Val_Rule DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE AD_Process ADD CONSTRAINT ADCtxHelp_ADProcess FOREIGN KEY (AD_CtxHelp_ID) REFERENCES AD_CtxHelp DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE AD_Ref_Table ADD CONSTRAINT ADInfoWindow_ADRefTable FOREIGN KEY (AD_InfoWindow_ID) REFERENCES AD_InfoWindow DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE AD_Tab ADD CONSTRAINT ADCtxHelp_ADTab FOREIGN KEY (AD_CtxHelp_ID) REFERENCES AD_CtxHelp DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE AD_Task ADD CONSTRAINT ADCtxHelp_ADTask FOREIGN KEY (AD_CtxHelp_ID) REFERENCES AD_CtxHelp DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE AD_UserDef_Field ADD CONSTRAINT ADReference_ADUserDefField FOREIGN KEY (AD_Reference_ID) REFERENCES AD_Reference DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE AD_UserDef_Field ADD CONSTRAINT ADReferenceValue_ADUserDefFiel FOREIGN KEY (AD_Reference_Value_ID) REFERENCES AD_Reference DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE AD_WF_Node ADD CONSTRAINT ADCtxHelp_ADWFNode FOREIGN KEY (AD_CtxHelp_ID) REFERENCES AD_CtxHelp DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE AD_WizardProcess ADD CONSTRAINT ADUser_ADWizardProcess FOREIGN KEY (AD_User_ID) REFERENCES AD_User DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE AD_Workflow ADD CONSTRAINT ADCtxHelp_ADWorkflow FOREIGN KEY (AD_CtxHelp_ID) REFERENCES AD_CtxHelp DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_AllocationHdr ADD CONSTRAINT Reversal_CAllocationHdr FOREIGN KEY (Reversal_ID) REFERENCES C_AllocationHdr DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_BankAccount_Processor ADD CONSTRAINT CCurrency_CBankAccountProcesso FOREIGN KEY (C_Currency_ID) REFERENCES C_Currency DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_BPartner ADD CONSTRAINT Default1099Box_CBPartner FOREIGN KEY (Default1099Box_ID) REFERENCES C_1099Box DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_BP_BankAccount ADD CONSTRAINT CPaymentProcessor_CBPBankAccou FOREIGN KEY (C_PaymentProcessor_ID) REFERENCES C_PaymentProcessor DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_BP_ShippingAcct ADD CONSTRAINT CBPartner_CBPShippingAcct FOREIGN KEY (C_BPartner_ID) REFERENCES C_BPartner DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_BP_ShippingAcct ADD CONSTRAINT CBPartnerLocation_CBPShippingA FOREIGN KEY (C_BPartner_Location_ID) REFERENCES C_BPartner_Location DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_BP_ShippingAcct ADD CONSTRAINT MShippingProcessor_CBPShipping FOREIGN KEY (M_ShippingProcessor_ID) REFERENCES M_ShippingProcessor DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_DepositBatch ADD CONSTRAINT CBankAccount_CDepositBatch FOREIGN KEY (C_BankAccount_ID) REFERENCES C_BankAccount DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_DepositBatch ADD CONSTRAINT CDocType_CDepositBatch FOREIGN KEY (C_DocType_ID) REFERENCES C_DocType DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_DepositBatchLine ADD CONSTRAINT CDepositBatch_CDepositBatchLin FOREIGN KEY (C_DepositBatch_ID) REFERENCES C_DepositBatch DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_DepositBatchLine ADD CONSTRAINT CPayment_CDepositBatchLine FOREIGN KEY (C_Payment_ID) REFERENCES C_Payment DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_InvoiceLine ADD CONSTRAINT C1099Box_CInvoiceLine FOREIGN KEY (C_1099Box_ID) REFERENCES C_1099Box DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_OnlineTrxHistory ADD CONSTRAINT ADTable_COnlineTrxHistory FOREIGN KEY (AD_Table_ID) REFERENCES AD_Table DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_Payment ADD CONSTRAINT CDepositBatch_CPayment FOREIGN KEY (C_DepositBatch_ID) REFERENCES C_DepositBatch DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_PaymentTransaction ADD CONSTRAINT ADOrgTrx_CPaymentTransaction FOREIGN KEY (AD_OrgTrx_ID) REFERENCES AD_Org DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_PaymentTransaction ADD CONSTRAINT CActivity_CPaymentTransaction FOREIGN KEY (C_Activity_ID) REFERENCES C_Activity DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_PaymentTransaction ADD CONSTRAINT CBankAccount_CPaymentTransacti FOREIGN KEY (C_BankAccount_ID) REFERENCES C_BankAccount DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_PaymentTransaction ADD CONSTRAINT CBPartner_CPaymentTransaction FOREIGN KEY (C_BPartner_ID) REFERENCES C_BPartner DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_PaymentTransaction ADD CONSTRAINT CBPBankAccount_CPaymentTransac FOREIGN KEY (C_BP_BankAccount_ID) REFERENCES C_BP_BankAccount DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_PaymentTransaction ADD CONSTRAINT CCampaign_CPaymentTransaction FOREIGN KEY (C_Campaign_ID) REFERENCES C_Campaign DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_PaymentTransaction ADD CONSTRAINT CCashBook_CPaymentTransaction FOREIGN KEY (C_CashBook_ID) REFERENCES C_CashBook DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_PaymentTransaction ADD CONSTRAINT CCharge_CPaymentTransaction FOREIGN KEY (C_Charge_ID) REFERENCES C_Charge DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_PaymentTransaction ADD CONSTRAINT CConversionType_CPaymentTransa FOREIGN KEY (C_ConversionType_ID) REFERENCES C_ConversionType DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_PaymentTransaction ADD CONSTRAINT CCurrency_CPaymentTransaction FOREIGN KEY (C_Currency_ID) REFERENCES C_Currency DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_PaymentTransaction ADD CONSTRAINT User1_CPaymentTransaction FOREIGN KEY (User1_ID) REFERENCES C_ElementValue DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_PaymentTransaction ADD CONSTRAINT User2_CPaymentTransaction FOREIGN KEY (User2_ID) REFERENCES C_ElementValue DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_PaymentTransaction ADD CONSTRAINT CInvoice_CPaymentTransaction FOREIGN KEY (C_Invoice_ID) REFERENCES C_Invoice DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_PaymentTransaction ADD CONSTRAINT COrder_CPaymentTransaction FOREIGN KEY (C_Order_ID) REFERENCES C_Order DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_PaymentTransaction ADD CONSTRAINT CPayment_CPaymentTransaction FOREIGN KEY (C_Payment_ID) REFERENCES C_Payment DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_PaymentTransaction ADD CONSTRAINT CPaymentBatch_CPaymentTransact FOREIGN KEY (C_PaymentBatch_ID) REFERENCES C_PaymentBatch DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_PaymentTransaction ADD CONSTRAINT CPaymentProcessor_CPaymentTran FOREIGN KEY (C_PaymentProcessor_ID) REFERENCES C_PaymentProcessor DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_PaymentTransaction ADD CONSTRAINT RefPaymentTransaction_CPayment FOREIGN KEY (Ref_PaymentTransaction_ID) REFERENCES C_PaymentTransaction DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_PaymentTransaction ADD CONSTRAINT CPOSTenderType_CPaymentTransac FOREIGN KEY (C_POSTenderType_ID) REFERENCES C_POSTenderType DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE C_PaymentTransaction ADD CONSTRAINT CProject_CPaymentTransaction FOREIGN KEY (C_Project_ID) REFERENCES C_Project DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE DD_Order ADD CONSTRAINT RefOrder_DDOrder FOREIGN KEY (Ref_Order_ID) REFERENCES C_Order DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE I_Invoice ADD CONSTRAINT C1099Box_IInvoice FOREIGN KEY (C_1099Box_ID) REFERENCES C_1099Box DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_CommodityShipment ADD CONSTRAINT MProduct_MCommodityShipment FOREIGN KEY (M_Product_ID) REFERENCES M_Product DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ForecastLine ADD CONSTRAINT SalesRep_MForecastLine FOREIGN KEY (SalesRep_ID) REFERENCES AD_User DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_InOut ADD CONSTRAINT ReturnUser_MInOut FOREIGN KEY (ReturnUser_ID) REFERENCES AD_User DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_InOut ADD CONSTRAINT ReturnBPartner_MInOut FOREIGN KEY (ReturnBPartner_ID) REFERENCES C_BPartner DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_InOut ADD CONSTRAINT ReturnLocation_MInOut FOREIGN KEY (ReturnLocation_ID) REFERENCES C_BPartner_Location DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_MatchInv ADD CONSTRAINT Reversal_MMatchInv FOREIGN KEY (Reversal_ID) REFERENCES M_MatchInv DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_MatchPO ADD CONSTRAINT Reversal_MMatchPO FOREIGN KEY (Reversal_ID) REFERENCES M_MatchPO DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_Package ADD CONSTRAINT CBPartnerLocation_MPackage FOREIGN KEY (C_BPartner_Location_ID) REFERENCES C_BPartner_Location DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_Package ADD CONSTRAINT CBPShippingAcct_MPackage FOREIGN KEY (C_BP_ShippingAcct_ID) REFERENCES C_BP_ShippingAcct DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_Package ADD CONSTRAINT CCurrency_MPackage FOREIGN KEY (C_Currency_ID) REFERENCES C_Currency DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_Package ADD CONSTRAINT CUOMLength_MPackage FOREIGN KEY (C_UOM_Length_ID) REFERENCES C_UOM DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_Package ADD CONSTRAINT CUOMWeight_MPackage FOREIGN KEY (C_UOM_Weight_ID) REFERENCES C_UOM DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_Package ADD CONSTRAINT MShipperLabels_MPackage FOREIGN KEY (M_ShipperLabels_ID) REFERENCES M_ShipperLabels DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_Package ADD CONSTRAINT MShipperPackaging_MPackage FOREIGN KEY (M_ShipperPackaging_ID) REFERENCES M_ShipperPackaging DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_Package ADD CONSTRAINT MShipperPickupTypes_MPackage FOREIGN KEY (M_ShipperPickupTypes_ID) REFERENCES M_ShipperPickupTypes DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_PackageLine ADD CONSTRAINT MPackageMPS_MPackageLine FOREIGN KEY (M_PackageMPS_ID) REFERENCES M_PackageMPS DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_PackageLine ADD CONSTRAINT MProduct_MPackageLine FOREIGN KEY (M_Product_ID) REFERENCES M_Product DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_PackageMPS ADD CONSTRAINT CUOMLength_MPackageMPS FOREIGN KEY (C_UOM_Length_ID) REFERENCES C_UOM DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_PackageMPS ADD CONSTRAINT CUOMWeight_MPackageMPS FOREIGN KEY (C_UOM_Weight_ID) REFERENCES C_UOM DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_PackageMPS ADD CONSTRAINT MPackage_MPackageMPS FOREIGN KEY (M_Package_ID) REFERENCES M_Package DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_Production ADD CONSTRAINT CBPartner_MProduction FOREIGN KEY (C_BPartner_ID) REFERENCES C_BPartner DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_RMALine ADD CONSTRAINT CTax_MRMALine FOREIGN KEY (C_Tax_ID) REFERENCES C_Tax DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_RMALine ADD CONSTRAINT MProduct_MRMALine FOREIGN KEY (M_Product_ID) REFERENCES M_Product DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_RMATax ADD CONSTRAINT CTax_MRMATax FOREIGN KEY (C_Tax_ID) REFERENCES C_Tax DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_RMATax ADD CONSTRAINT MRMA_MRMATax FOREIGN KEY (M_RMA_ID) REFERENCES M_RMA DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_Shipper ADD CONSTRAINT MShipperCfg_MShipper FOREIGN KEY (M_ShipperCfg_ID) REFERENCES M_ShipperCfg DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_Shipper ADD CONSTRAINT MShippingProcessor_MShipper FOREIGN KEY (M_ShippingProcessor_ID) REFERENCES M_ShippingProcessor DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShipperCfg ADD CONSTRAINT MShippingProcessorCfg_MShipper FOREIGN KEY (M_ShippingProcessorCfg_ID) REFERENCES M_ShippingProcessorCfg DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShipperLabels ADD CONSTRAINT MShipper_MShipperLabels FOREIGN KEY (M_Shipper_ID) REFERENCES M_Shipper DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShipperLabels ADD CONSTRAINT MShipperLabelsCfg_MShipperLabe FOREIGN KEY (M_ShipperLabelsCfg_ID) REFERENCES M_ShipperLabelsCfg DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShipperLabelsCfg ADD CONSTRAINT MShipperCfg_MShipperLabelsCfg FOREIGN KEY (M_ShipperCfg_ID) REFERENCES M_ShipperCfg DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShipperPackaging ADD CONSTRAINT MShipper_MShipperPackaging FOREIGN KEY (M_Shipper_ID) REFERENCES M_Shipper DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShipperPackaging ADD CONSTRAINT MShipperPackagingCfg_MShipperP FOREIGN KEY (M_ShipperPackagingCfg_ID) REFERENCES M_ShipperPackagingCfg DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShipperPackagingCfg ADD CONSTRAINT MShipperCfg_MShipperPackagingC FOREIGN KEY (M_ShipperCfg_ID) REFERENCES M_ShipperCfg DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShipperPickupTypes ADD CONSTRAINT MShipper_MShipperPickupTypes FOREIGN KEY (M_Shipper_ID) REFERENCES M_Shipper DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShipperPickupTypes ADD CONSTRAINT MShipperPickupTypesCfg_MShippe FOREIGN KEY (M_ShipperPickupTypesCfg_ID) REFERENCES M_ShipperPickupTypesCfg DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShipperPickupTypesCfg ADD CONSTRAINT MShipperCfg_MShipperPickupType FOREIGN KEY (M_ShipperCfg_ID) REFERENCES M_ShipperCfg DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShippingProcessor ADD CONSTRAINT MShippingProcessorCfg_MShippin FOREIGN KEY (M_ShippingProcessorCfg_ID) REFERENCES M_ShippingProcessorCfg DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShippingTransaction ADD CONSTRAINT ADUser_MShippingTransaction FOREIGN KEY (AD_User_ID) REFERENCES AD_User DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShippingTransaction ADD CONSTRAINT ReturnUser_MShippingTransactio FOREIGN KEY (ReturnUser_ID) REFERENCES AD_User DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShippingTransaction ADD CONSTRAINT SalesRep_MShippingTransaction FOREIGN KEY (SalesRep_ID) REFERENCES AD_User DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShippingTransaction ADD CONSTRAINT CBPartner_MShippingTransaction FOREIGN KEY (C_BPartner_ID) REFERENCES C_BPartner DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShippingTransaction ADD CONSTRAINT ReturnBPartner_MShippingTransa FOREIGN KEY (ReturnBPartner_ID) REFERENCES C_BPartner DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShippingTransaction ADD CONSTRAINT BillLocation_MShippingTransact FOREIGN KEY (Bill_Location_ID) REFERENCES C_BPartner_Location DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShippingTransaction ADD CONSTRAINT CBPartnerLocation_MShippingTra FOREIGN KEY (C_BPartner_Location_ID) REFERENCES C_BPartner_Location DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShippingTransaction ADD CONSTRAINT ReturnLocation_MShippingTransa FOREIGN KEY (ReturnLocation_ID) REFERENCES C_BPartner_Location DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShippingTransaction ADD CONSTRAINT CBPShippingAcct_MShippingTrans FOREIGN KEY (C_BP_ShippingAcct_ID) REFERENCES C_BP_ShippingAcct DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShippingTransaction ADD CONSTRAINT CCurrency_MShippingTransaction FOREIGN KEY (C_Currency_ID) REFERENCES C_Currency DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShippingTransaction ADD CONSTRAINT CInvoice_MShippingTransaction FOREIGN KEY (C_Invoice_ID) REFERENCES C_Invoice DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShippingTransaction ADD CONSTRAINT COrder_MShippingTransaction FOREIGN KEY (C_Order_ID) REFERENCES C_Order DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShippingTransaction ADD CONSTRAINT CUOMLength_MShippingTransactio FOREIGN KEY (C_UOM_Length_ID) REFERENCES C_UOM DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShippingTransaction ADD CONSTRAINT CUOMWeight_MShippingTransactio FOREIGN KEY (C_UOM_Weight_ID) REFERENCES C_UOM DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShippingTransaction ADD CONSTRAINT MInOut_MShippingTransaction FOREIGN KEY (M_InOut_ID) REFERENCES M_InOut DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShippingTransaction ADD CONSTRAINT MPackage_MShippingTransaction FOREIGN KEY (M_Package_ID) REFERENCES M_Package DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShippingTransaction ADD CONSTRAINT MShipper_MShippingTransaction FOREIGN KEY (M_Shipper_ID) REFERENCES M_Shipper DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShippingTransaction ADD CONSTRAINT MShipperLabels_MShippingTransa FOREIGN KEY (M_ShipperLabels_ID) REFERENCES M_ShipperLabels DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShippingTransaction ADD CONSTRAINT MShipperPackaging_MShippingTra FOREIGN KEY (M_ShipperPackaging_ID) REFERENCES M_ShipperPackaging DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShippingTransaction ADD CONSTRAINT MShipperPickupTypes_MShippingT FOREIGN KEY (M_ShipperPickupTypes_ID) REFERENCES M_ShipperPickupTypes DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShippingTransaction ADD CONSTRAINT MShippingProcessor_MShippingTr FOREIGN KEY (M_ShippingProcessor_ID) REFERENCES M_ShippingProcessor DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShippingTransaction ADD CONSTRAINT MWarehouse_MShippingTransactio FOREIGN KEY (M_Warehouse_ID) REFERENCES M_Warehouse DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShippingTransactionLine ADD CONSTRAINT CUOMLength_MShippingTransactLn FOREIGN KEY (C_UOM_Length_ID) REFERENCES C_UOM DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShippingTransactionLine ADD CONSTRAINT CUOMWeight_MShippingTransactLn FOREIGN KEY (C_UOM_Weight_ID) REFERENCES C_UOM DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShippingTransactionLine ADD CONSTRAINT MPackageMPS_MShippingTransacti FOREIGN KEY (M_PackageMPS_ID) REFERENCES M_PackageMPS DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_ShippingTransactionLine ADD CONSTRAINT MShippingTransaction_MShipping FOREIGN KEY (M_ShippingTransaction_ID) REFERENCES M_ShippingTransaction DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_StorageOnHand ADD CONSTRAINT MProduct_MStorageOnHand FOREIGN KEY (M_Product_ID) REFERENCES M_Product DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_StorageReservation ADD CONSTRAINT MProduct_MStorageReservation FOREIGN KEY (M_Product_ID) REFERENCES M_Product DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_StorageReservation ADD CONSTRAINT MWarehouse_MStorageReservation FOREIGN KEY (M_Warehouse_ID) REFERENCES M_Warehouse DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_Warehouse ADD CONSTRAINT MReserveLocator_MWarehouse FOREIGN KEY (M_ReserveLocator_ID) REFERENCES M_Locator DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE WS_WebServiceFieldInput ADD CONSTRAINT ADReference_WSWebServiceFieldI FOREIGN KEY (AD_Reference_ID) REFERENCES AD_Reference DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE WS_WebServiceFieldInput ADD CONSTRAINT ADReferenceValue_WSWebServiceF FOREIGN KEY (AD_Reference_Value_ID) REFERENCES AD_Reference DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_StorageOnHand ADD CONSTRAINT MAttributeSetInstance_MStoraOH FOREIGN KEY(M_AttributeSetInstance_ID) REFERENCES M_AttributeSetInstance(M_AttributeSetInstance_ID) DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_StorageOnHand ADD CONSTRAINT MLocator_MStorageOnHand FOREIGN KEY(M_Locator_ID) REFERENCES M_Locator(M_Locator_ID) DEFERRABLE INITIALLY DEFERRED
;

ALTER TABLE M_StorageReservation ADD CONSTRAINT MAttributeSetInstance_MStoraRe FOREIGN KEY(M_AttributeSetInstance_ID) REFERENCES M_AttributeSetInstance(M_AttributeSetInstance_ID) DEFERRABLE INITIALLY DEFERRED
;

SELECT register_migration_script('201304181526_IdxFKs.sql') FROM dual
;

