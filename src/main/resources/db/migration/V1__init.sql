-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Host: mariadb
-- Generation Time: Jun 18, 2025 at 09:15 AM
-- Server version: 11.7.2-MariaDB-ubu2404
-- PHP Version: 8.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `crm_chatbot`
--

-- --------------------------------------------------------

--
-- Table structure for table `blacklisted_tokens`
--

CREATE TABLE `blacklisted_tokens` (
  `token` varchar(255) NOT NULL,
  `expiry_date` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `blacklisted_tokens`
--

INSERT INTO `blacklisted_tokens` (`token`, `expiry_date`) VALUES
('eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzYW1wYXRoLmRpZ2FtYWR1bGxhQGV4YW1wbGUuY29tIiwiaWF0IjoxNzQ5Mzc2NTE4LCJleHAiOjE3NDkzODAxMTh9.s_clYRydAVsOKM02sfbUcSrX0r8GZ7lRvbBPd3hZFh0', '2025-06-08 10:55:18.000000');

-- --------------------------------------------------------

--
-- Table structure for table `chat`
--

CREATE TABLE `chat` (
  `id` bigint(20) NOT NULL,
  `customer_email` varchar(255) DEFAULT NULL,
  `intent` varchar(255) DEFAULT NULL,
  `message` text NOT NULL,
  `metadata` text DEFAULT NULL,
  `sender` enum('AGENT','BOT','CUSTOMER') NOT NULL,
  `session_id` varchar(255) NOT NULL,
  `timestamp` datetime(6) NOT NULL,
  `agent_id` bigint(20) DEFAULT NULL,
  `version` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chat`
--

INSERT INTO `chat` (`id`, `customer_email`, `intent`, `message`, `metadata`, `sender`, `session_id`, `timestamp`, `agent_id`, `version`) VALUES
(1, NULL, NULL, 'i need a travel insurance', NULL, 'CUSTOMER', 'user123', '2025-06-17 22:14:58.550000', NULL, 'General'),
(2, NULL, 'NULL', 'Please provide the following details to proceed with your travel insurance quote:\n\nFull Name:\nEmail:\nContact Number:\nDestination:\nTravel Dates:\nTraveller Age(s):', NULL, 'AGENT', 'user123', '2025-06-17 22:15:07.725000', NULL, 'General'),
(3, 'bhanu@gmail.com', NULL, 'Bhanu,bhanu@gmail.com,2313231,India,2025/06/11-2025/06/13,24', NULL, 'CUSTOMER', 'user123', '2025-06-17 22:15:37.212000', NULL, 'General'),
(4, NULL, 'Travel Insurance', 'Insurance Type: Travel Insurance\nFull Name: Bhanu\nEmail: bhanu@gmail.com\nContact Number: 2313231\nDestination: India\nTravel Dates: 2025/06/11-2025/06/13\nTraveller Age(s): 24\n\nThank you. Your details have been passed to our team. An agent will contact you shortly with your quote.', NULL, 'AGENT', 'user123', '2025-06-17 22:15:46.111000', NULL, 'General'),
(5, NULL, NULL, 'i need a vehicle insurance', NULL, 'CUSTOMER', 'user_345', '2025-06-17 22:17:37.102000', NULL, 'General'),
(6, NULL, 'NULL', 'Could you please provide me with the following details to assist you with your vehicle insurance?\n\nName,  \nEmail,  \nContact Number,  \nVehicle Model,  \nVehicle Number,  \nYear of Manufacture,  \nUsage Type (private/commercial),  \nEstimated Value.  \n\nOnce I have this information, I can proceed with your request!', NULL, 'AGENT', 'user_345', '2025-06-17 22:17:44.032000', NULL, 'General'),
(7, 'johndoe@example.com', NULL, 'John Doe, johndoe@example.com, +1 234 567 8900, Toyota Corolla, AB-1234, 2018, Private, 6mn', NULL, 'CUSTOMER', 'user_345', '2025-06-17 22:20:15.002000', NULL, 'General'),
(8, NULL, 'Motor Insurance', 'Insurance Type: Motor Insurance  \nFull Name: John Doe  \nEmail: johndoe@example.com  \nContact Number: +1 234 567 8900  \nVehicle Model: Toyota Corolla  \nVehicle Number: AB-1234  \nYear of Manufacture: 2018  \nUsage Type: Private  \nEstimated Value: 6mn  \n\nThank you. Your details have been passed to our team. An agent will contact you shortly with your quote.', NULL, 'AGENT', 'user_345', '2025-06-17 22:20:23.710000', NULL, 'General'),
(9, NULL, NULL, 'who is the ceo?', NULL, 'CUSTOMER', 'user_234', '2025-06-17 22:23:49.335000', NULL, 'AR'),
(10, NULL, NULL, 'Ms. Jeevani Kariyawasam is the Chief Executive Officer (CEO) of People\'s Insurance PLC. She has been with the company since its establishment and has over 25 years of experience in the insurance industry. 😊', NULL, 'AGENT', 'user_234', '2025-06-17 22:24:00.591000', NULL, 'AR'),
(11, NULL, NULL, 'who are the board of directors?', NULL, 'CUSTOMER', 'user_34', '2025-06-17 22:25:01.810000', NULL, 'AR'),
(12, NULL, NULL, '📋 Board of Directors (As per 2024 Annual Report)\n1. Mr. Isuru Balapatabendi - Chairman, Non-Executive, Non-Independent Director, resigned on 18th November 2024\n2. Mr. Sanjeewa Bandaranayake – Non-Executive, Non-Independent Director\n3. Ms. Nayanganie Wickramasingha – Non-Executive, Independent Director\n4. Mr. Johnson Fernando – Non-Executive, Independent Director\n5. Dr. Kasun Wijetilleke – Non-Executive, Independent Director\n6. Mr. Azzam Ahamat – Non-Executive, Non-Independent Director\n7. Mr. Dulinda Perera – Non-Executive, Non-Independent Director', NULL, 'AGENT', 'user_34', '2025-06-17 22:25:11.872000', NULL, 'AR'),
(13, NULL, NULL, 'i am going to dubai next week', NULL, 'CUSTOMER', 'user_34345', '2025-06-17 22:26:49.387000', NULL, 'General'),
(14, NULL, 'NULL', 'That sounds exciting! If you\'re looking for travel insurance for your trip to Dubai, I can help you with that. Please provide the following details:\n\nName,\nEmail,\nContact Number,\nDestination (Dubai),\nTravel Dates,\nTraveller Age(s).\n\nOnce I have this information, I can assist you further! 😊', NULL, 'AGENT', 'user_34345', '2025-06-17 22:27:00.699000', NULL, 'General'),
(15, 'shenal@gmail.com', NULL, 'Shenal,shenal@gmail.com,2342342,Dubai,2025/06/15-2025/06/17,26', NULL, 'CUSTOMER', 'user_34345', '2025-06-17 22:28:08.373000', NULL, 'General'),
(16, NULL, 'Travel Insurance', 'Insurance Type: Travel Insurance  \nFull Name: Shenal  \nEmail: shenal@gmail.com  \nContact Number: 2342342  \nDestination: Dubai  \nTravel Dates: 2025/06/15-2025/06/17  \nTraveller Age(s): 26  \n\nThank you. Your details have been passed to our team. An agent will contact you shortly with your quote.', NULL, 'AGENT', 'user_34345', '2025-06-17 22:28:16.702000', NULL, 'General'),
(17, NULL, NULL, 'how do i insure my vehicle?', NULL, 'CUSTOMER', 'user12789', '2025-06-17 22:29:06.080000', NULL, 'General'),
(18, NULL, 'NULL', 'To insure your vehicle with People\'s Insurance, you can follow these steps:\n\n1. **Choose the Type of Insurance**: Decide whether you need Motor Insurance, which can include comprehensive coverage, third-party fire and theft, or third-party only.\n\n2. **Gather Required Information**: For Motor Insurance, you will need to provide the following details:\n   - Name\n   - Email\n   - Contact Number\n   - Vehicle Model\n   - Vehicle Number\n   - Year of Manufacture\n   - Usage Type (private/commercial)\n   - Estimated Value\n\n3. **Contact Us**: You can reach out to our team through our hotline or visit a branch to get assistance with your insurance application.\n\nIf you\'re ready to proceed with a quote, please provide the required details, and I\'ll help you capture that information! 😊', NULL, 'AGENT', 'user12789', '2025-06-17 22:29:15.352000', NULL, 'General'),
(19, 'janesmith@example.com', NULL, 'Jane Smith, janesmith@example.com, +44 7700 900123, Honda Civic, XY-5678, 2020, Commercial, 8mn', NULL, 'CUSTOMER', 'user12789', '2025-06-17 22:30:29.394000', NULL, 'General'),
(20, NULL, 'Motor Insurance', 'Insurance Type: Motor Insurance  \nFull Name: Jane Smith  \nEmail: janesmith@example.com  \nContact Number: +44 7700 900123  \nVehicle Model: Honda Civic  \nVehicle Number: XY-5678  \nYear of Manufacture: 2020  \nUsage Type: Commercial  \nEstimated Value: 8mn  \n\nThank you. Your details have been passed to our team. An agent will contact you shortly with your quote.', NULL, 'AGENT', 'user12789', '2025-06-17 22:30:37.573000', NULL, 'General'),
(21, NULL, NULL, 'How do i get a motor insurance', NULL, 'CUSTOMER', 'user5567', '2025-06-17 22:39:35.939000', NULL, 'General'),
(22, NULL, 'NULL', 'To get motor insurance, you can follow these steps:\n\n1. **Choose the Type of Coverage**: Decide whether you need comprehensive coverage or third-party insurance.\n\n2. **Gather Required Information**: You\'ll need details such as your vehicle model, vehicle number, year of manufacture, usage type (private or commercial), and estimated value.\n\n3. **Contact Us for a Quote**: You can reach out to People\'s Insurance to get a quote. \n\nIf you\'re ready to proceed, please provide the following details:\n\n- Name\n- Email\n- Contact Number\n- Vehicle Model\n- Vehicle Number\n- Year of Manufacture\n- Usage Type (private/commercial)\n- Estimated Value\n\nOnce I have this information, I can assist you further! 😊', NULL, 'AGENT', 'user5567', '2025-06-17 22:39:48.897000', NULL, 'General'),
(23, 'michaelbrown@example.com', NULL, 'Michael Brown, michaelbrown@example.com, +61 412 345 678, Ford Ranger, CD-7890, 2019, Private, 7mn', NULL, 'CUSTOMER', 'user5567', '2025-06-17 22:40:21.768000', NULL, 'General'),
(24, NULL, 'Motor Insurance', 'Insurance Type: Motor Insurance  \nFull Name: Michael Brown  \nEmail: michaelbrown@example.com  \nContact Number: +61 412 345 678  \nVehicle Model: Ford Ranger  \nVehicle Number: CD-7890  \nYear of Manufacture: 2019  \nUsage Type: Private  \nEstimated Value: 7mn  \n\nThank you. Your details have been passed to our team. An agent will contact you shortly with your quote.', NULL, 'AGENT', 'user5567', '2025-06-17 22:40:28.766000', NULL, 'General'),
(25, NULL, NULL, 'i need a travel insurance', NULL, 'CUSTOMER', 'customer_345', '2025-06-18 14:34:48.239000', NULL, 'General'),
(26, NULL, 'NULL', 'Please provide the following details to proceed with your travel insurance:\n\nFull Name:\nEmail:\nContact Number:\nDestination:\nTravel Dates:\nTraveller Age(s):', NULL, 'AGENT', 'customer_345', '2025-06-18 14:34:56.999000', NULL, 'General'),
(27, 'bhanu@gmail.com', NULL, 'Bhanu,bhanu@gmail.com,076123123,India,2025/06/11-2025/06/13,25', NULL, 'CUSTOMER', 'customer_345', '2025-06-18 14:36:15.954000', NULL, 'General'),
(28, NULL, 'Travel Insurance', 'Insurance Type: Travel Insurance\nFull Name: Bhanu\nEmail: bhanu@gmail.com\nContact Number: 076123123\nDestination: India\nTravel Dates: 2025/06/11-2025/06/13\nTraveller Age(s): 25\n\nThank you. Your details have been passed to our team. An agent will contact you shortly with your quote.', NULL, 'AGENT', 'customer_345', '2025-06-18 14:36:24.502000', NULL, 'General');

-- --------------------------------------------------------

--
-- Table structure for table `event_publication`
--

CREATE TABLE `event_publication` (
  `id` uuid NOT NULL,
  `completion_date` datetime(6) DEFAULT NULL,
  `event_type` varchar(255) DEFAULT NULL,
  `listener_id` varchar(255) DEFAULT NULL,
  `publication_date` datetime(6) DEFAULT NULL,
  `serialized_event` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `leads`
--

CREATE TABLE `leads` (
  `id` bigint(20) NOT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `estimated_value` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `insurance_type` varchar(255) DEFAULT NULL,
  `session_id` varchar(255) NOT NULL,
  `status` enum('CLOSED','NEW','ON_HOLD') NOT NULL,
  `timestamp` datetime(6) NOT NULL,
  `travel_dates` varchar(255) DEFAULT NULL,
  `traveller_age` varchar(255) DEFAULT NULL,
  `usage_type` varchar(255) DEFAULT NULL,
  `vehicle_model` varchar(255) DEFAULT NULL,
  `vehicle_number` varchar(255) DEFAULT NULL,
  `year_of_manufacture` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `leads`
--

INSERT INTO `leads` (`id`, `contact_number`, `destination`, `email`, `estimated_value`, `full_name`, `insurance_type`, `session_id`, `status`, `timestamp`, `travel_dates`, `traveller_age`, `usage_type`, `vehicle_model`, `vehicle_number`, `year_of_manufacture`) VALUES
(1, '2313231', 'India', 'bhanu@gmail.com', NULL, 'Bhanu', 'Travel Insurance', 'user123', 'NEW', '2025-06-17 22:15:46.116000', '2025/06/11', '24', NULL, NULL, NULL, NULL),
(2, '+1 234 567 8900', NULL, 'johndoe@example.com', '6mn', 'John Doe', 'Motor Insurance', 'user_345', 'NEW', '2025-06-17 22:20:23.719000', NULL, NULL, 'Private', 'Toyota Corolla', 'AB-1234', '2018'),
(3, '2342342', 'Dubai', 'shenal@gmail.com', NULL, 'Shenal', 'Travel Insurance', 'user_34345', 'NEW', '2025-06-17 22:28:16.709000', '2025/06/15', '26', NULL, NULL, NULL, NULL),
(4, '+44 7700 900123', NULL, 'janesmith@example.com', '8mn', 'Jane Smith', 'Motor Insurance', 'user12789', 'NEW', '2025-06-17 22:30:37.578000', NULL, NULL, 'Commercial', 'Honda Civic', 'XY-5678', '2020'),
(5, '+61 412 345 678', NULL, 'michaelbrown@example.com', '7mn', 'Michael Brown', 'Motor Insurance', 'user5567', 'ON_HOLD', '2025-06-17 22:40:28.770000', NULL, NULL, 'Private', 'Ford Ranger', 'CD-7890', '2019'),
(6, '076123123', 'India', 'bhanu@gmail.com', NULL, 'Bhanu', 'Travel Insurance', 'customer_345', 'NEW', '2025-06-18 14:36:24.528000', '2025/06/11', '25', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `SPRING_SESSION`
--

CREATE TABLE `SPRING_SESSION` (
  `PRIMARY_ID` char(36) NOT NULL,
  `SESSION_ID` char(36) NOT NULL,
  `CREATION_TIME` bigint(20) NOT NULL,
  `LAST_ACCESS_TIME` bigint(20) NOT NULL,
  `MAX_INACTIVE_INTERVAL` int(11) NOT NULL,
  `EXPIRY_TIME` bigint(20) NOT NULL,
  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `SPRING_SESSION_ATTRIBUTES`
--

CREATE TABLE `SPRING_SESSION_ATTRIBUTES` (
  `SESSION_PRIMARY_ID` char(36) NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `approval_status` enum('APPROVED','PENDING','REJECTED') NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('ADMIN','AGENT') NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `approval_status`, `created_at`, `email`, `password`, `role`, `updated_at`, `first_name`, `last_name`) VALUES
(1, 'APPROVED', '2025-06-08 11:59:58.000000', 'sampath@peoplesinsurance.lk', '$2a$12$V3rhGHQuZ31qBByZMih7z.NPMkctfb41nkUCaPkWbnCeAb6Zxispe', 'ADMIN', '2025-06-08 11:59:58.000000', 'Sampath', 'Digamadulla'),
(2, 'PENDING', '2025-06-08 14:57:56.609000', 'shanelsilva785@gmail.com', '$2a$12$XyafyEOAjfRWhk8RRWZei.u.bblF21B/dGnHe7OwRIfafzNNS.nMy', 'AGENT', '2025-06-08 14:57:56.609000', 'Shanel', 'Silva'),
(3, 'PENDING', '2025-06-08 15:27:04.025000', 'ravishkayohan@gmail.com', '$2a$12$KKSVReNwNuDeOSZCtVfIYuO7JwsxKGWQE6WVRfXmtsvI4LHOpEWTe', 'AGENT', '2025-06-08 15:27:04.025000', 'Ravishka', 'Wijewardhana'),
(4, 'PENDING', '2025-06-08 15:49:22.587000', 'test@gmail.com', '$2a$12$Do2bCZ6g/c4UODeCZyK0wuDNB5LVEgHZ27hZ.VG4G8.RSlulmkRsW', 'AGENT', '2025-06-08 15:49:22.587000', 'Test', 'Test');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `blacklisted_tokens`
--
ALTER TABLE `blacklisted_tokens`
  ADD PRIMARY KEY (`token`);

--
-- Indexes for table `chat`
--
ALTER TABLE `chat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkwfs7d45o3bbdhmqkukkptrex` (`agent_id`);

--
-- Indexes for table `event_publication`
--
ALTER TABLE `event_publication`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `leads`
--
ALTER TABLE `leads`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `SPRING_SESSION`
--
ALTER TABLE `SPRING_SESSION`
  ADD PRIMARY KEY (`PRIMARY_ID`),
  ADD UNIQUE KEY `SPRING_SESSION_IX1` (`SESSION_ID`),
  ADD KEY `SPRING_SESSION_IX2` (`EXPIRY_TIME`),
  ADD KEY `SPRING_SESSION_IX3` (`PRINCIPAL_NAME`);

--
-- Indexes for table `SPRING_SESSION_ATTRIBUTES`
--
ALTER TABLE `SPRING_SESSION_ATTRIBUTES`
  ADD PRIMARY KEY (`SESSION_PRIMARY_ID`,`ATTRIBUTE_NAME`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chat`
--
ALTER TABLE `chat`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `leads`
--
ALTER TABLE `leads`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chat`
--
ALTER TABLE `chat`
  ADD CONSTRAINT `FKkwfs7d45o3bbdhmqkukkptrex` FOREIGN KEY (`agent_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `SPRING_SESSION_ATTRIBUTES`
--
ALTER TABLE `SPRING_SESSION_ATTRIBUTES`
  ADD CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES `SPRING_SESSION` (`PRIMARY_ID`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
