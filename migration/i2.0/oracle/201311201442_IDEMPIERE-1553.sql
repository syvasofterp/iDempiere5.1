SET SQLBLANKLINES ON
SET DEFINE OFF

-- Nov 20, 2013 2:41:50 PM CET
-- IDEMPIERE-1553
UPDATE AD_Column SET DefaultValue=NULL, ValueMax=NULL, ValueMin=NULL,Updated=TO_DATE('2013-11-20 14:41:50','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=200484
;

SELECT register_migration_script('201311201442_IDEMPIERE-1553.sql') FROM dual
;