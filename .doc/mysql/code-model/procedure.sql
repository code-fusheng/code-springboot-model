CREATE PROCEDURE learn_multi_results()
BEGIN
SELECT id, model_name FROM code_model WHERE id > 1;
SELECT id, model_name FROM code_model WHERE model_name = 'test';
END