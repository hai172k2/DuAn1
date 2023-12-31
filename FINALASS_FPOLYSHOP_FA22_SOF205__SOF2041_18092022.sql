create database asss1
go
use asss1

/****** Object:  Table [dbo].[ChiTietSP]    Script Date: 6/8/2023 11:03:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietSP](
	[Id] [uniqueidentifier] NOT NULL,
	[IdSP] [uniqueidentifier] NULL,
	[IdNsx] [uniqueidentifier] NULL,
	[IdMauSac] [uniqueidentifier] NULL,
	[IdDongSP] [uniqueidentifier] NULL,
	[NamBH] [int] NULL,
	[MoTa] [nvarchar](50) NULL,
	[SoLuongTon] [int] NULL,
	[GiaNhap] [decimal](20, 0) NULL,
	[GiaBan] [decimal](20, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChucVu]    Script Date: 6/8/2023 11:03:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChucVu](
	[Id] [uniqueidentifier] NOT NULL,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CuaHang]    Script Date: 6/8/2023 11:03:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CuaHang](
	[Id] [uniqueidentifier] NOT NULL,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](100) NULL,
	[ThanhPho] [nvarchar](50) NULL,
	[QuocGia] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DongSP]    Script Date: 6/8/2023 11:03:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DongSP](
	[Id] [uniqueidentifier] NOT NULL,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GioHang]    Script Date: 6/8/2023 11:03:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GioHang](
	[Id] [uniqueidentifier] NOT NULL,
	[IdKH] [uniqueidentifier] NULL,
	[IdNV] [uniqueidentifier] NULL,
	[Ma] [varchar](20) NULL,
	[NgayTao] [date] NULL,
	[NgayThanhToan] [date] NULL,
	[TenNguoiNhan] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](100) NULL,
	[Sdt] [varchar](30) NULL,
	[TinhTrang] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GioHangChiTiet]    Script Date: 6/8/2023 11:03:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GioHangChiTiet](
	[IdGioHang] [uniqueidentifier] NOT NULL,
	[IdChiTietSP] [uniqueidentifier] NOT NULL,
	[SoLuong] [int] NULL,
	[DonGia] [decimal](20, 0) NULL,
	[DonGiaKhiGiam] [decimal](20, 0) NULL,
	[id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_GioHangCT] PRIMARY KEY CLUSTERED 
(
	[IdGioHang] ASC,
	[IdChiTietSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 6/8/2023 11:03:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[Id] [uniqueidentifier] NOT NULL,
	[IdKH] [uniqueidentifier] NULL,
	[IdNV] [uniqueidentifier] NULL,
	[Ma] [varchar](20) NULL,
	[NgayTao] [date] NULL,
	[NgayThanhToan] [datetime] NULL,
	[NgayShip] [date] NULL,
	[NgayNhan] [date] NULL,
	[TinhTrang] [int] NULL,
	[TenNguoiNhan] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](100) NULL,
	[Sdt] [varchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonChiTiet]    Script Date: 6/8/2023 11:03:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonChiTiet](
	[IdHoaDon] [uniqueidentifier] NOT NULL,
	[IdChiTietSP] [uniqueidentifier] NOT NULL,
	[SoLuong] [int] NULL,
	[DonGia] [decimal](20, 0) NULL,
 CONSTRAINT [PK_HoaDonCT] PRIMARY KEY CLUSTERED 
(
	[IdHoaDon] ASC,
	[IdChiTietSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 6/8/2023 11:03:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[Id] [uniqueidentifier] NOT NULL,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](30) NULL,
	[TenDem] [nvarchar](30) NULL,
	[Ho] [nvarchar](30) NULL,
	[NgaySinh] [date] NULL,
	[Sdt] [varchar](30) NULL,
	[DiaChi] [nvarchar](100) NULL,
	[ThanhPho] [nvarchar](50) NULL,
	[QuocGia] [nvarchar](50) NULL,
	[MatKhau] [varchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MauSac]    Script Date: 6/8/2023 11:03:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MauSac](
	[Id] [uniqueidentifier] NOT NULL,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 6/8/2023 11:03:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[Id] [uniqueidentifier] NOT NULL,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](30) NULL,
	[TenDem] [nvarchar](30) NULL,
	[Ho] [nvarchar](30) NULL,
	[GioiTinh] [nvarchar](10) NULL,
	[NgaySinh] [date] NULL,
	[DiaChi] [nvarchar](100) NULL,
	[Sdt] [varchar](30) NULL,
	[MatKhau] [varchar](max) NULL,
	[IdCH] [uniqueidentifier] NULL,
	[IdCV] [uniqueidentifier] NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NSX]    Script Date: 6/8/2023 11:03:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NSX](
	[Id] [uniqueidentifier] NOT NULL,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 6/8/2023 11:03:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[Id] [uniqueidentifier] NOT NULL,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ChiTietSP] ([Id], [IdSP], [IdNsx], [IdMauSac], [IdDongSP], [NamBH], [MoTa], [SoLuongTon], [GiaNhap], [GiaBan]) VALUES (N'c9e9e498-1bad-46f4-8d28-2742ac57b1c5', N'dadea2d3-431c-4c21-a937-35c130ccca4d', N'9f763fd0-ad83-4301-8f04-633f32d415ea', N'2d758533-3ec1-454a-9959-2a6066ee7885', N'83eb2ff2-fc30-4d82-8b68-4d057b1e89fd', 40, N'dstretgrews', 530, CAST(435435 AS Decimal(20, 0)), CAST(56546 AS Decimal(20, 0)))
INSERT [dbo].[ChiTietSP] ([Id], [IdSP], [IdNsx], [IdMauSac], [IdDongSP], [NamBH], [MoTa], [SoLuongTon], [GiaNhap], [GiaBan]) VALUES (N'bc96c5f9-33af-4e2f-a8ec-8cf7314fceb4', N'dadea2d3-431c-4c21-a937-35c130ccca4d', N'9f763fd0-ad83-4301-8f04-633f32d415ea', N'2d758533-3ec1-454a-9959-2a6066ee7885', N'8d21b6b5-f344-4bc7-acf9-068ac54484b5', 43254, N'34', 3438, CAST(54645 AS Decimal(20, 0)), CAST(67556 AS Decimal(20, 0)))
INSERT [dbo].[ChiTietSP] ([Id], [IdSP], [IdNsx], [IdMauSac], [IdDongSP], [NamBH], [MoTa], [SoLuongTon], [GiaNhap], [GiaBan]) VALUES (N'081e04a1-c064-42cb-b5c5-f130828e8f8e', N'dadea2d3-431c-4c21-a937-35c130ccca4d', N'2d114bda-60a0-45a6-aed7-82447cbd08cc', N'8cce098f-9da7-48f7-a00c-37243f88573e', N'8d21b6b5-f344-4bc7-acf9-068ac54484b5', 213, N'54654', 45343, CAST(345 AS Decimal(20, 0)), CAST(65477564 AS Decimal(20, 0)))
INSERT [dbo].[ChiTietSP] ([Id], [IdSP], [IdNsx], [IdMauSac], [IdDongSP], [NamBH], [MoTa], [SoLuongTon], [GiaNhap], [GiaBan]) VALUES (N'92e807a4-4d89-40f7-9025-f328480c31f0', N'dadea2d3-431c-4c21-a937-35c130ccca4d', N'9f763fd0-ad83-4301-8f04-633f32d415ea', N'8cce098f-9da7-48f7-a00c-37243f88573e', N'8d21b6b5-f344-4bc7-acf9-068ac54484b5', 2435, N'sdfsd', 325436, CAST(54654 AS Decimal(20, 0)), CAST(54765 AS Decimal(20, 0)))
GO
INSERT [dbo].[ChucVu] ([Id], [Ma], [Ten]) VALUES (N'684f8730-ee51-4874-b312-1642ae1caf9e', N'01', N'quản lýy')
INSERT [dbo].[ChucVu] ([Id], [Ma], [Ten]) VALUES (N'26e7abe1-9e40-4b5f-af35-3c89a2ef8a36', N'', N'')
GO
INSERT [dbo].[CuaHang] ([Id], [Ma], [Ten], [DiaChi], [ThanhPho], [QuocGia]) VALUES (N'b7d0b0c6-82d1-4881-a05c-023b54edbbfc', N'32435', N'654645', N'2345235', N'324324', N'54353')
INSERT [dbo].[CuaHang] ([Id], [Ma], [Ten], [DiaChi], [ThanhPho], [QuocGia]) VALUES (N'01895b92-5390-47b7-bf93-9a98edf2e904', N'3243555555', N'654645', N'2345235', N'324324', N'54353')
GO
INSERT [dbo].[DongSP] ([Id], [Ma], [Ten]) VALUES (N'8d21b6b5-f344-4bc7-acf9-068ac54484b5', N'01', N'011')
INSERT [dbo].[DongSP] ([Id], [Ma], [Ten]) VALUES (N'83eb2ff2-fc30-4d82-8b68-4d057b1e89fd', N'02', N'02')
GO
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [Ma], [NgayTao], [NgayThanhToan], [NgayShip], [NgayNhan], [TinhTrang], [TenNguoiNhan], [DiaChi], [Sdt]) VALUES (N'042d4bad-f099-4343-88c7-29525e110639', N'5227252a-462d-44c8-ab1a-dc2d4e721a38', N'a631d222-61f6-4a8e-b998-2d9b01f9e8fa', N'321453341', CAST(N'2023-06-06' AS Date), CAST(N'2023-06-07T14:02:29.880' AS DateTime), CAST(N'2023-06-06' AS Date), CAST(N'2023-06-06' AS Date), 0, N'322', N'Hnoi', N'0332429178')
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [Ma], [NgayTao], [NgayThanhToan], [NgayShip], [NgayNhan], [TinhTrang], [TenNguoiNhan], [DiaChi], [Sdt]) VALUES (N'85487e52-6178-41d5-a386-3ea6a6f01a59', N'5ae59d17-afaf-42f9-9007-f408a675326b', N'a631d222-61f6-4a8e-b998-2d9b01f9e8fa', N'234456', CAST(N'2023-06-07' AS Date), CAST(N'2023-06-07T21:03:14.873' AS DateTime), CAST(N'2023-06-07' AS Date), CAST(N'2023-06-07' AS Date), 0, N'456', N'4356', N'75463')
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [Ma], [NgayTao], [NgayThanhToan], [NgayShip], [NgayNhan], [TinhTrang], [TenNguoiNhan], [DiaChi], [Sdt]) VALUES (N'66d2c343-2dc9-4626-88dc-a02703e62e1b', N'5227252a-462d-44c8-ab1a-dc2d4e721a38', N'a631d222-61f6-4a8e-b998-2d9b01f9e8fa', N'564324324', CAST(N'2023-06-08' AS Date), CAST(N'2023-06-08T01:04:31.380' AS DateTime), CAST(N'2023-06-08' AS Date), CAST(N'2023-06-08' AS Date), 0, N'4563', N'567', N'54')
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [Ma], [NgayTao], [NgayThanhToan], [NgayShip], [NgayNhan], [TinhTrang], [TenNguoiNhan], [DiaChi], [Sdt]) VALUES (N'226e7fd2-1916-43ea-be10-a934c6fa693b', N'5227252a-462d-44c8-ab1a-dc2d4e721a38', N'a631d222-61f6-4a8e-b998-2d9b01f9e8fa', N'321453345', CAST(N'2023-06-07' AS Date), CAST(N'2023-06-07T21:04:03.027' AS DateTime), CAST(N'2023-06-07' AS Date), CAST(N'2023-06-07' AS Date), 0, N'342', N'534', N'3425')
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [Ma], [NgayTao], [NgayThanhToan], [NgayShip], [NgayNhan], [TinhTrang], [TenNguoiNhan], [DiaChi], [Sdt]) VALUES (N'94b65ae8-c4b4-4d2a-9678-cc43fdec457c', N'5227252a-462d-44c8-ab1a-dc2d4e721a38', N'a631d222-61f6-4a8e-b998-2d9b01f9e8fa', N'32145331', CAST(N'2023-06-06' AS Date), CAST(N'2023-06-07T14:02:42.943' AS DateTime), CAST(N'2023-06-06' AS Date), CAST(N'2023-06-06' AS Date), 0, N'322', N'Hnoi', N'0332429178')
GO
INSERT [dbo].[HoaDonChiTiet] ([IdHoaDon], [IdChiTietSP], [SoLuong], [DonGia]) VALUES (N'66d2c343-2dc9-4626-88dc-a02703e62e1b', N'c9e9e498-1bad-46f4-8d28-2742ac57b1c5', 5, CAST(56546 AS Decimal(20, 0)))
INSERT [dbo].[HoaDonChiTiet] ([IdHoaDon], [IdChiTietSP], [SoLuong], [DonGia]) VALUES (N'66d2c343-2dc9-4626-88dc-a02703e62e1b', N'bc96c5f9-33af-4e2f-a8ec-8cf7314fceb4', 3, CAST(67556 AS Decimal(20, 0)))
INSERT [dbo].[HoaDonChiTiet] ([IdHoaDon], [IdChiTietSP], [SoLuong], [DonGia]) VALUES (N'226e7fd2-1916-43ea-be10-a934c6fa693b', N'c9e9e498-1bad-46f4-8d28-2742ac57b1c5', 3, CAST(56546 AS Decimal(20, 0)))
INSERT [dbo].[HoaDonChiTiet] ([IdHoaDon], [IdChiTietSP], [SoLuong], [DonGia]) VALUES (N'226e7fd2-1916-43ea-be10-a934c6fa693b', N'bc96c5f9-33af-4e2f-a8ec-8cf7314fceb4', 4, CAST(67556 AS Decimal(20, 0)))
GO
INSERT [dbo].[KhachHang] ([Id], [Ma], [Ten], [TenDem], [Ho], [NgaySinh], [Sdt], [DiaChi], [ThanhPho], [QuocGia], [MatKhau]) VALUES (N'5227252a-462d-44c8-ab1a-dc2d4e721a38', N'001', N'cuong', N'duy', N'nguyen', CAST(N'2002-10-03' AS Date), N'0349602002', N'tu the', N'bac ninh', N'vietnam', N'123')
INSERT [dbo].[KhachHang] ([Id], [Ma], [Ten], [TenDem], [Ho], [NgaySinh], [Sdt], [DiaChi], [ThanhPho], [QuocGia], [MatKhau]) VALUES (N'5ae59d17-afaf-42f9-9007-f408a675326b', N'002', N'hi', N'haha', N'kkk', NULL, NULL, NULL, NULL, NULL, NULL)
GO
INSERT [dbo].[MauSac] ([Id], [Ma], [Ten]) VALUES (N'2d758533-3ec1-454a-9959-2a6066ee7885', N'02', N'000022')
INSERT [dbo].[MauSac] ([Id], [Ma], [Ten]) VALUES (N'8cce098f-9da7-48f7-a00c-37243f88573e', N'01', N'dooooo')
GO
INSERT [dbo].[NhanVien] ([Id], [Ma], [Ten], [TenDem], [Ho], [GioiTinh], [NgaySinh], [DiaChi], [Sdt], [MatKhau], [IdCH], [IdCV], [TrangThai]) VALUES (N'a631d222-61f6-4a8e-b998-2d9b01f9e8fa', N'3432', N'435435', N'435435465', N'546754', N'nữ', CAST(N'2002-02-02' AS Date), N'rew', N'324', N'', N'b7d0b0c6-82d1-4881-a05c-023b54edbbfc', N'684f8730-ee51-4874-b312-1642ae1caf9e', 0)
INSERT [dbo].[NhanVien] ([Id], [Ma], [Ten], [TenDem], [Ho], [GioiTinh], [NgaySinh], [DiaChi], [Sdt], [MatKhau], [IdCH], [IdCV], [TrangThai]) VALUES (N'f87d3c09-a8de-4e28-b5d4-98bc52c45c41', N'2344567', N'543654', N'56475', N'75674', N'nữ', CAST(N'2003-08-02' AS Date), N'34543', N'0954435', N'', N'b7d0b0c6-82d1-4881-a05c-023b54edbbfc', N'26e7abe1-9e40-4b5f-af35-3c89a2ef8a36', 1)
GO
INSERT [dbo].[NSX] ([Id], [Ma], [Ten]) VALUES (N'9f763fd0-ad83-4301-8f04-633f32d415ea', N'nsx04', N'gucci')
INSERT [dbo].[NSX] ([Id], [Ma], [Ten]) VALUES (N'2d114bda-60a0-45a6-aed7-82447cbd08cc', N'nsx03', N'nsx03')
INSERT [dbo].[NSX] ([Id], [Ma], [Ten]) VALUES (N'03934076-8d41-48aa-8ff9-df0edf9c6f21', N'nsx02', N'nsx0322')
GO
INSERT [dbo].[SanPham] ([Id], [Ma], [Ten]) VALUES (N'dadea2d3-431c-4c21-a937-35c130ccca4d', N'01', N'sp1')
INSERT [dbo].[SanPham] ([Id], [Ma], [Ten]) VALUES (N'8031449c-a517-42a6-83d8-52b0d6edd835', N'sp3', N'sp3')
INSERT [dbo].[SanPham] ([Id], [Ma], [Ten]) VALUES (N'f3a2262f-6509-4b56-a328-d5d15cb39f2d', N'02', N'sp2')
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__ChucVu__3214CC9E42E8522F]    Script Date: 6/8/2023 11:03:52 AM ******/
ALTER TABLE [dbo].[ChucVu] ADD UNIQUE NONCLUSTERED 
(
	[Ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__CuaHang__3214CC9E36A50EFE]    Script Date: 6/8/2023 11:03:52 AM ******/
ALTER TABLE [dbo].[CuaHang] ADD UNIQUE NONCLUSTERED 
(
	[Ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__DongSP__3214CC9E152285D3]    Script Date: 6/8/2023 11:03:52 AM ******/
ALTER TABLE [dbo].[DongSP] ADD UNIQUE NONCLUSTERED 
(
	[Ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__GioHang__3214CC9EB0B719DA]    Script Date: 6/8/2023 11:03:52 AM ******/
ALTER TABLE [dbo].[GioHang] ADD UNIQUE NONCLUSTERED 
(
	[Ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__KhachHan__3214CC9E473C8BAF]    Script Date: 6/8/2023 11:03:52 AM ******/
ALTER TABLE [dbo].[KhachHang] ADD UNIQUE NONCLUSTERED 
(
	[Ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__MauSac__3214CC9EDC250862]    Script Date: 6/8/2023 11:03:52 AM ******/
ALTER TABLE [dbo].[MauSac] ADD UNIQUE NONCLUSTERED 
(
	[Ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__NhanVien__3214CC9E09F2A54C]    Script Date: 6/8/2023 11:03:52 AM ******/
ALTER TABLE [dbo].[NhanVien] ADD UNIQUE NONCLUSTERED 
(
	[Ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__NSX__3214CC9E623A67C2]    Script Date: 6/8/2023 11:03:52 AM ******/
ALTER TABLE [dbo].[NSX] ADD UNIQUE NONCLUSTERED 
(
	[Ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__SanPham__3214CC9E9C6726E7]    Script Date: 6/8/2023 11:03:52 AM ******/
ALTER TABLE [dbo].[SanPham] ADD UNIQUE NONCLUSTERED 
(
	[Ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ChiTietSP] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[ChiTietSP] ADD  DEFAULT (NULL) FOR [NamBH]
GO
ALTER TABLE [dbo].[ChiTietSP] ADD  DEFAULT (NULL) FOR [MoTa]
GO
ALTER TABLE [dbo].[ChiTietSP] ADD  DEFAULT ((0)) FOR [GiaNhap]
GO
ALTER TABLE [dbo].[ChiTietSP] ADD  DEFAULT ((0)) FOR [GiaBan]
GO
ALTER TABLE [dbo].[ChucVu] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[ChucVu] ADD  DEFAULT (NULL) FOR [Ten]
GO
ALTER TABLE [dbo].[CuaHang] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[CuaHang] ADD  DEFAULT (NULL) FOR [Ten]
GO
ALTER TABLE [dbo].[CuaHang] ADD  DEFAULT (NULL) FOR [DiaChi]
GO
ALTER TABLE [dbo].[CuaHang] ADD  DEFAULT (NULL) FOR [ThanhPho]
GO
ALTER TABLE [dbo].[CuaHang] ADD  DEFAULT (NULL) FOR [QuocGia]
GO
ALTER TABLE [dbo].[DongSP] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[GioHang] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[GioHang] ADD  DEFAULT (NULL) FOR [NgayTao]
GO
ALTER TABLE [dbo].[GioHang] ADD  DEFAULT (NULL) FOR [NgayThanhToan]
GO
ALTER TABLE [dbo].[GioHang] ADD  DEFAULT (NULL) FOR [TenNguoiNhan]
GO
ALTER TABLE [dbo].[GioHang] ADD  DEFAULT (NULL) FOR [DiaChi]
GO
ALTER TABLE [dbo].[GioHang] ADD  DEFAULT (NULL) FOR [Sdt]
GO
ALTER TABLE [dbo].[GioHang] ADD  DEFAULT ((0)) FOR [TinhTrang]
GO
ALTER TABLE [dbo].[GioHangChiTiet] ADD  DEFAULT ((0)) FOR [DonGia]
GO
ALTER TABLE [dbo].[GioHangChiTiet] ADD  DEFAULT ((0)) FOR [DonGiaKhiGiam]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [NgayTao]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [NgayShip]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [NgayNhan]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT ((0)) FOR [TinhTrang]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [TenNguoiNhan]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [DiaChi]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [Sdt]
GO
ALTER TABLE [dbo].[HoaDonChiTiet] ADD  DEFAULT ((0)) FOR [DonGia]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [TenDem]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [Ho]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [NgaySinh]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [Sdt]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [DiaChi]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [ThanhPho]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [QuocGia]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [MatKhau]
GO
ALTER TABLE [dbo].[MauSac] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (NULL) FOR [Ten]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (NULL) FOR [TenDem]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (NULL) FOR [Ho]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (NULL) FOR [GioiTinh]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (NULL) FOR [NgaySinh]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (NULL) FOR [DiaChi]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (NULL) FOR [Sdt]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (NULL) FOR [MatKhau]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[NSX] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[SanPham] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[ChiTietSP]  WITH CHECK ADD FOREIGN KEY([IdDongSP])
REFERENCES [dbo].[DongSP] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSP]  WITH CHECK ADD FOREIGN KEY([IdMauSac])
REFERENCES [dbo].[MauSac] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSP]  WITH CHECK ADD FOREIGN KEY([IdNsx])
REFERENCES [dbo].[NSX] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSP]  WITH CHECK ADD FOREIGN KEY([IdSP])
REFERENCES [dbo].[SanPham] ([Id])
GO
ALTER TABLE [dbo].[GioHang]  WITH CHECK ADD FOREIGN KEY([IdKH])
REFERENCES [dbo].[KhachHang] ([Id])
GO
ALTER TABLE [dbo].[GioHangChiTiet]  WITH CHECK ADD  CONSTRAINT [FK1_IdGioHang] FOREIGN KEY([IdGioHang])
REFERENCES [dbo].[GioHang] ([Id])
GO
ALTER TABLE [dbo].[GioHangChiTiet] CHECK CONSTRAINT [FK1_IdGioHang]
GO
ALTER TABLE [dbo].[GioHangChiTiet]  WITH CHECK ADD  CONSTRAINT [FK2_IdChiTietSP] FOREIGN KEY([IdChiTietSP])
REFERENCES [dbo].[ChiTietSP] ([Id])
GO
ALTER TABLE [dbo].[GioHangChiTiet] CHECK CONSTRAINT [FK2_IdChiTietSP]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([IdKH])
REFERENCES [dbo].[KhachHang] ([Id])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([IdNV])
REFERENCES [dbo].[NhanVien] ([Id])
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK1] FOREIGN KEY([IdHoaDon])
REFERENCES [dbo].[HoaDon] ([Id])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK1]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK2] FOREIGN KEY([IdChiTietSP])
REFERENCES [dbo].[ChiTietSP] ([Id])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK2]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD FOREIGN KEY([IdCH])
REFERENCES [dbo].[CuaHang] ([Id])
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD FOREIGN KEY([IdCV])
REFERENCES [dbo].[ChucVu] ([Id])
GO
select * from ChiTietSP
select * from  ChucVu
select * from  NhanVien
select * from MauSac

delete from ChiTietSP where id = N'709776D5-D33E-4A49-8EE3-990640AB7454'
delete from ChucVu where id = N'E17124AC-4BCF-4EF9-B827-85D6DA3FFD0B'
delete from NhanVien where id = N'9C81D51A-E1B8-40E0-BD7E-855A54544AFC'