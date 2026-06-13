INSERT INTO servicos (tipo_servico, categoria, bairro, cidade, estado, endereco, valor, data_servico, horario_inicio, horario_fim, requisitos, contratante, avaliacao, possui_assinatura, status)
SELECT 'Instalação Ar-Condicionado', 'Elétrica', 'Vila Madalena', 'São Paulo', 'SP', 'Rua das Purpurinas, 123', 280.00, '2026-06-13', '09:00', '11:00', 'Levar escada e ferramentas próprias', 'João Silva', 4.8, TRUE, 'AGUARDANDO_ACEITE'
WHERE NOT EXISTS (SELECT 1 FROM servicos WHERE tipo_servico = 'Instalação Ar-Condicionado' AND contratante = 'João Silva');

INSERT INTO servicos (tipo_servico, categoria, bairro, cidade, estado, endereco, valor, data_servico, horario_inicio, horario_fim, requisitos, contratante, avaliacao, possui_assinatura, status)
SELECT 'Limpeza Pós-Obra', 'Limpeza Residencial', 'Moema', 'São Paulo', 'SP', 'Avenida Ibirapuera, 456', 152.00, '2026-06-14', '08:00', '12:00', 'Trazer kit de limpeza básico', 'Maria Rocha', 4.9, FALSE, 'AGUARDANDO_ACEITE'
WHERE NOT EXISTS (SELECT 1 FROM servicos WHERE tipo_servico = 'Limpeza Pós-Obra' AND contratante = 'Maria Rocha');

INSERT INTO servicos (tipo_servico, categoria, bairro, cidade, estado, endereco, valor, data_servico, horario_inicio, horario_fim, requisitos, contratante, avaliacao, possui_assinatura, status)
SELECT 'Apartamento Standard', 'Limpeza Residencial', 'Vila Olímpia', 'São Paulo', 'SP', 'Rua Funchal, 789', 144.00, '2026-10-14', '08:00', '12:00', 'Trazer kit de limpeza básico (vassoura, pano, detergente);Foco especial na varanda e vidraças externas;Acesso pelo portão de serviços (interfone 201)', 'M. Rocha', 4.9, TRUE, 'AGUARDANDO_ACEITE'
WHERE NOT EXISTS (SELECT 1 FROM servicos WHERE tipo_servico = 'Apartamento Standard' AND contratante = 'M. Rocha');