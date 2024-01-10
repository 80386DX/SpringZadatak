INSERT INTO FormularPopunjen (idFormular, vremeKreiranja, vremePoslednjeIzmene)
VALUES
  (55,'2023-11-21 15:30:00', '2023-11-21 15:45:00'),
  (15,'2023-07-21 15:00:00', '2023-09-21 15:45:00'),
  (88,'2023-12-21 18:02:20', '2023-12-21 20:45:00'),
  (100,'2023-02-02 11:22:00', '2023-12-21 20:55:00');

INSERT INTO PoljePopunjeno (idFormularPopunjen, idPolje, vrednostTekst, vrednostBroj, vremeKreiranja, vremePoslednjeIzmene)
VALUES
  (1, 10, 'Etwas', 12.50, '2023-11-21 15:35:00', '2023-11-21 15:40:00'),
  (1, 15, 'Nesto', 35.89, '2023-11-21 15:40:00', '2023-11-21 15:45:00'),
  (2, 20, 'Something', 100.00, '2023-12-05 09:15:00', '2023-12-05 09:20:00');


INSERT INTO PoljePopunjeno (korisnickoIme, lozinka, vremeKreiranja, vremePoslednjeIzmene)
VALUES
  ('Pera', 'lozinka111', '2022-11-21 19:45:00', '2023-12-15 16:42:00'),
  ('Zika', 'sifra55', '2021-08-15 08:00:00', '2023-04-19 17:22:00'),
  ('Laza', 's!fra55', '2023-01-01 09:22:10', '2023-05-23 10:31:00');


