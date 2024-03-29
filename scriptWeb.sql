USE [project]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 12/26/2023 8:02:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[categoryID] [nvarchar](50) NOT NULL,
	[nameCategory] [nvarchar](200) NULL,
	[parentCategoryID] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[categoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customers]    Script Date: 12/26/2023 8:02:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customers](
	[customerID] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](100) NULL,
	[password] [nvarchar](50) NULL,
	[nameCustomer] [nvarchar](100) NULL,
	[numberPhone] [varchar](20) NULL,
	[email] [nvarchar](50) NULL,
	[address] [nvarchar](200) NULL,
	[role] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[customerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Discounts]    Script Date: 12/26/2023 8:02:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Discounts](
	[discountID] [nvarchar](50) NOT NULL,
	[nameDiscount] [nvarchar](200) NULL,
	[discountPercentage] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[discountID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderItems]    Script Date: 12/26/2023 8:02:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderItems](
	[orderID] [nvarchar](50) NULL,
	[productID] [nvarchar](50) NULL,
	[quantity] [smallint] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 12/26/2023 8:02:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[orderID] [nvarchar](50) NOT NULL,
	[customerID] [int] NULL,
	[orderDate] [smalldatetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[orderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ParentCategories]    Script Date: 12/26/2023 8:02:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ParentCategories](
	[parentCategoryID] [nvarchar](50) NOT NULL,
	[nameCategory] [nvarchar](200) NULL,
	[imageURL] [nvarchar](500) NULL,
PRIMARY KEY CLUSTERED 
(
	[parentCategoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 12/26/2023 8:02:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[productID] [nvarchar](50) NOT NULL,
	[nameProduct] [nvarchar](200) NULL,
	[description] [nvarchar](500) NULL,
	[price] [float] NULL,
	[imageURL] [nvarchar](500) NULL,
	[categoryID] [nvarchar](50) NULL,
	[discountID] [nvarchar](50) NULL,
	[unit] [nvarchar](200) NULL,
	[available] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[productID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Categories] ([categoryID], [nameCategory], [parentCategoryID]) VALUES (N'CA001', N'Cá Tươi', N'DM02')
INSERT [dbo].[Categories] ([categoryID], [nameCategory], [parentCategoryID]) VALUES (N'CQ01', N'Củ, Quả', N'DM03')
INSERT [dbo].[Categories] ([categoryID], [nameCategory], [parentCategoryID]) VALUES (N'DU001', N'Nước Ngọt', N'DM06')
INSERT [dbo].[Categories] ([categoryID], [nameCategory], [parentCategoryID]) VALUES (N'DU002', N'Nước Suối', N'DM06')
INSERT [dbo].[Categories] ([categoryID], [nameCategory], [parentCategoryID]) VALUES (N'DU003', N'Cà Phê', N'DM06')
INSERT [dbo].[Categories] ([categoryID], [nameCategory], [parentCategoryID]) VALUES (N'DU004', N'Đồ Uống Có Cồn', N'DM06')
INSERT [dbo].[Categories] ([categoryID], [nameCategory], [parentCategoryID]) VALUES (N'DU005', N'Trà Các Loại Khác', N'DM06')
INSERT [dbo].[Categories] ([categoryID], [nameCategory], [parentCategoryID]) VALUES (N'RL01', N'Rau Lá', N'DM03')
INSERT [dbo].[Categories] ([categoryID], [nameCategory], [parentCategoryID]) VALUES (N'TC001', N'Trái Cây Tươi', N'DM05')
INSERT [dbo].[Categories] ([categoryID], [nameCategory], [parentCategoryID]) VALUES (N'TH001', N'Thịt Heo', N'DM01')
INSERT [dbo].[Categories] ([categoryID], [nameCategory], [parentCategoryID]) VALUES (N'TH002', N'Thịt Bò', N'DM01')
INSERT [dbo].[Categories] ([categoryID], [nameCategory], [parentCategoryID]) VALUES (N'TH003', N'Thịt-Các Loại Khác', N'DM01')
GO
SET IDENTITY_INSERT [dbo].[Customers] ON 

INSERT [dbo].[Customers] ([customerID], [username], [password], [nameCustomer], [numberPhone], [email], [address], [role]) VALUES (1, N'hieu', N'tuan', N'leminhhieu', N'03457777777', N'leminhhieu.ltp2021@gmail.com', N'linh trung', 0)
INSERT [dbo].[Customers] ([customerID], [username], [password], [nameCustomer], [numberPhone], [email], [address], [role]) VALUES (2, N'haha', N'aa', N'hieu', N'03934', N'sss@gmail.com', N'hcm', 1)
INSERT [dbo].[Customers] ([customerID], [username], [password], [nameCustomer], [numberPhone], [email], [address], [role]) VALUES (3, N'chuotcon', N'chuotcon', N'Tráº§n VÄn Chuá»t', N'0365943549', N'leminhhieu.ltp2021@gmail.com', N'HCM city', 0)
INSERT [dbo].[Customers] ([customerID], [username], [password], [nameCustomer], [numberPhone], [email], [address], [role]) VALUES (4, N'kiki777', N'7777', N'Le Bao', N'0365943549', N'mattroima@yahoo.com', N'HCM', 0)
INSERT [dbo].[Customers] ([customerID], [username], [password], [nameCustomer], [numberPhone], [email], [address], [role]) VALUES (5, N'kuroko2003', N'hieule2003', N'Le Bao', N'0365943549', N'mattroima@yahoo.com', N'Thu Duc, HCM', 0)
SET IDENTITY_INSERT [dbo].[Customers] OFF
GO
INSERT [dbo].[Discounts] ([discountID], [nameDiscount], [discountPercentage]) VALUES (N'DC10', N'Giảm giá sản phẩm mới - 10%', 10)
INSERT [dbo].[Discounts] ([discountID], [nameDiscount], [discountPercentage]) VALUES (N'DC15', N'Giảm giá sản phẩm cuối ngày - 15%', 15)
GO
INSERT [dbo].[ParentCategories] ([parentCategoryID], [nameCategory], [imageURL]) VALUES (N'DM01', N'Thịt', N'images/category/thịt.png')
INSERT [dbo].[ParentCategories] ([parentCategoryID], [nameCategory], [imageURL]) VALUES (N'DM02', N'Hải Sản', N'images/category/cá.png')
INSERT [dbo].[ParentCategories] ([parentCategoryID], [nameCategory], [imageURL]) VALUES (N'DM03', N'Rau Củ', N'images/category/rau củ.png')
INSERT [dbo].[ParentCategories] ([parentCategoryID], [nameCategory], [imageURL]) VALUES (N'DM04', N'Đồ Hộp', N'images/category/đồ hộp.png')
INSERT [dbo].[ParentCategories] ([parentCategoryID], [nameCategory], [imageURL]) VALUES (N'DM05', N'Trái Cây', N'images/category/trái cây.png')
INSERT [dbo].[ParentCategories] ([parentCategoryID], [nameCategory], [imageURL]) VALUES (N'DM06', N'Đồ Uống', N'images/category/nước giải khát.png')
INSERT [dbo].[ParentCategories] ([parentCategoryID], [nameCategory], [imageURL]) VALUES (N'DM07', N'Khác', N'images/category/thực phẩm khác.png')
GO
INSERT [dbo].[Products] ([productID], [nameProduct], [description], [price], [imageURL], [categoryID], [discountID], [unit], [available]) VALUES (N'SP001', N'Cà Chua', N' Cà chua là loại rau củ rất tốt cho sức khoẻ nhờ chứa nhiều dinh dưỡng đặc biệt là vitamin A, C, K ngoài ra loại quả này còn giúp làm đẹp da cho phái nữ rất tốt. Cà chua được trồng tại Lâm Đồng có thể ăn sống hoặc chế biến các món ăn cũng rất phù hợp.', 30000, N'images/product/product-1.jpg', N'CQ01', N'DC10', N'1KG', 1)
INSERT [dbo].[Products] ([productID], [nameProduct], [description], [price], [imageURL], [categoryID], [discountID], [unit], [available]) VALUES (N'SP002', N'Khóm Ngọt', N'Thơm là một loại trái cây vừa ngon, chua chua ngọt ngọt lại vừa cung cấp rất nhiều chất dinh dưỡng cho cơ thể. Thơm có thể chế biến thành nhiều món ăn khác nhau như: làm nước ép, kho, xào,... mỗi một món sẽ mang lại một hương vị khác nhau.', 45000, N'images/product/product-2.jpg', N'CQ01', NULL, N'1KG', 1)
INSERT [dbo].[Products] ([productID], [nameProduct], [description], [price], [imageURL], [categoryID], [discountID], [unit], [available]) VALUES (N'SP003', N'Ớt Hiểm', N'Ớt hiểm có vị cay nồng, thơm, kích thích vị giác của người ăn, ớt là một trong những gia vị không thể thiếu trong nấu ăn cũng như mâm cơm của người Việt. Ớt hiểm luôn giữ được độ tươi mỗi ngày, được nuôi trồng theo quy trình nghiêm ngặt, bảo đảm các chỉ tiêu về an toàn và chất lượng.', 20000, N'images/product/product-3.jpg', N'RL01', NULL, N'Gói', 1)
INSERT [dbo].[Products] ([productID], [nameProduct], [description], [price], [imageURL], [categoryID], [discountID], [unit], [available]) VALUES (N'SP004', N'Dâu Tây Đà Lạt ', N' Dâu tây là loại trái cây có vị chua ngọt, giàu dinh dưỡng. Dâu tây giống Mỹ được trồng tại Đà Lạt, có đóng gói hộp giấy kỹ càng, an toàn đảm bảo trái dâu tươi ngon, không bị dập khi giao hàng đến khách hàng. Dâu tây có thể ăn trực tiếp hoặc chế biến nhiều món ăn và nước uống ngon.', 70000, N'images/product/product-4.jpg', N'RL01', NULL, N'0.5KG', 1)
INSERT [dbo].[Products] ([productID], [nameProduct], [description], [price], [imageURL], [categoryID], [discountID], [unit], [available]) VALUES (N'SP005', N'Dưa Leo', N' Dưa leo trái lớn tươi ngon, được trồng và thu hoạch đảm bảo chất lượng, an toàn cho sức khỏe người sử dụng. Trong dưa leo chứa nhiều chất xơ, vitamin C, E, K, magie,...dễ ăn, dễ phối trộn với các món ăn khác, tốt sức khỏe vừa mang lại hiệu quả làm đẹp rất tốt', 25000, N'images/product/product-5.jpg', N'CQ01', NULL, N'1KG', 1)
INSERT [dbo].[Products] ([productID], [nameProduct], [description], [price], [imageURL], [categoryID], [discountID], [unit], [available]) VALUES (N'SP006', N'Khoai Tây', N' Khoai tây trồng tại Trung Quốc đã quá quen thuộc với mỗi chúng ta. Loại củ này được xuất hiện thường xuyên trên mâm cơm này có rất nhiều công dụng hữu ích. Khoai tây không chỉ có thể chế biến nhiều món ăn ngon mà còn tốt cho sức khỏe, làm đẹp hiệu quả mà còn có rất nhiều tác dụng bổ ích khác.', 30000, N'images/product/product-7.jpg', N'CQ01', NULL, N'1KG', 1)
INSERT [dbo].[Products] ([productID], [nameProduct], [description], [price], [imageURL], [categoryID], [discountID], [unit], [available]) VALUES (N'SP007', N'Chuối', N' Chuối già là loại trái cây chứa nhiều chất dinh dưỡng như kali, chất xơ, vitamin,... Chuối ăn ngon nhất khi chín vàng, vị ngọt nhẹ, thơm ngon. 
Chuối được đảm bảo nguồn gốc, trồng tại các tỉnh như Bình Phước, Tây Ninh,... tuỳ theo mùa vụ
Sản phẩm cam kết đạt chuẩn 100% AT VSTP', 40000, N'images/product/product-8.jpg', N'RL01', N'DC15', N'1KG', 1)
INSERT [dbo].[Products] ([productID], [nameProduct], [description], [price], [imageURL], [categoryID], [discountID], [unit], [available]) VALUES (N'SP008', N'Trà Đào Hạt Chia', N'Trà đào và hạt chia Fuzetea​ thành phần nguyên liệu được lựa chọn kỹ lưỡng, không chứa hóa chất độc hại, an toàn cho người dùng. Sản phẩm được sản xuất trên quy trình công nghệ hiện đại, kiểm duyệt chặt chẽ, đảm bảo chất lượng, được ưa chuộng trên thị trường. Trà đào và hạt chia Fuzetea​ có thành phần tự nhiên từ nước, đường mía, đường HFCS, nước trái cây, hạt chia, chất điều chỉnh độ axit, hương đào tự nhiên...', 50000, N'images/product/trà đào hạt chia.jpg', N'DU001', N'DC10', N'Lóc', 1)
INSERT [dbo].[Products] ([productID], [nameProduct], [description], [price], [imageURL], [categoryID], [discountID], [unit], [available]) VALUES (N'SP009', N'Đùi Bò', N'Đùi bò được lấy từ con bò tốt nhất Việt Nam. Là loại thịt bò hảo hạng nhất Việt Nam', 350000, N'images/product/đùi-bò.jpg', N'TH002', N'DC10', N'1KG', 1)
INSERT [dbo].[Products] ([productID], [nameProduct], [description], [price], [imageURL], [categoryID], [discountID], [unit], [available]) VALUES (N'SP010', N'Xương Đuôi Heo', N' Xương đuôi Heo  chứa nhiều chất dinh dưỡng có ích như: protein 26,4%, lipid 22,7%, glucid 4% và nhiều chất khoáng vi lượng như Ca, P, Fe…
Chất protein của đuôi động vật, chủ yếu là ở da, gồm nhiều chất hợp thành như: collagen, elastin, keratin, albumin, globulin…', 55000, N'images/product/xương-đuôi-heo.jpg', N'TH001', N'DC15', N'1KG', 1)
INSERT [dbo].[Products] ([productID], [nameProduct], [description], [price], [imageURL], [categoryID], [discountID], [unit], [available]) VALUES (N'SP011', N'Hành Tây', N' Hành tây có một số lợi ích sức khỏe, chủ yếu là do hàm lượng chất chống oxy hóa cao và các hợp chất chứa lưu huỳnh. Ăn hành tây có tác dụng kháng viêm, đồng thời giảm nguy cơ ung thư, hạ lượng đường trong máu và cải thiện sức khỏe của xương.', 30000, N'images/product/hành-tây.jpg', N'CQ01', N'DC10', N'1KG', 1)
INSERT [dbo].[Products] ([productID], [nameProduct], [description], [price], [imageURL], [categoryID], [discountID], [unit], [available]) VALUES (N'SP012', N'Táo Xanh', N' Táo xanh được trồng ở Bình Thuận, rất ngọt, ngon bổ rẻ.', 45900, N'images/product/tao_xanh.jpg', N'TC001', N'DC15', N'1KG', 1)
INSERT [dbo].[Products] ([productID], [nameProduct], [description], [price], [imageURL], [categoryID], [discountID], [unit], [available]) VALUES (N'SP013', N'Dưa Hấu', N' Dưa hấu không hạt là giống quả mới lạ và độc đáo. Quả dưa tròn, da xanh nhạt có gân xanh đậm, vỏ mỏng, nhiều nước, không có hạt và vị ngọt đậm đà. Đây là loại trái cây giải khát tuyệt vời, ngoài việc sử dụng trực tiếp còn dùng để làm các loại nước ép sinh tố rất bổ dưỡng. Chỉ với một ly nước ép hoặc sinh tố buổi sáng là bạn đã bổ sung năng lượng cho mọi hoạt động hàng ngày. ', 40000, N'images/product/Dưa hấu không hạt.jpg', N'TC001', N'DC10', N'1KG', 1)
INSERT [dbo].[Products] ([productID], [nameProduct], [description], [price], [imageURL], [categoryID], [discountID], [unit], [available]) VALUES (N'SP014', N'Cá Rô Phi Lê', N' Cá rô phi lê, còn được gọi là cá hồi, là một loại cá nước ngọt nổi tiếng với thịt ngon và giàu axit béo omega-3, có lợi cho sức khỏe. Dưới đây là mô tả về sản phẩm cá rô phi lê. Thịt cá rô phi lê nổi tiếng với độ ngon và dai, với hương vị đặc trưng của cá hồi. Đặc biệt, thịt chứa nhiều axit béo omega-3 giúp hỗ trợ sức khỏe tim mạch và não bộ.', 129000, N'images/product/ca_phi_le.jpg', N'CA001', N'DC15', N'1KG', 1)
INSERT [dbo].[Products] ([productID], [nameProduct], [description], [price], [imageURL], [categoryID], [discountID], [unit], [available]) VALUES (N'SP015', N'Xà Lách Xanh', N' Sản phẩm được trồng và chế biến từ các trang trại hữu cơ chất lượng cao, nơi không sử dụng hóa chất độc hại hay thuốc trừ sâu, để đảm bảo an toàn và tinh khiết. Xà lách xanh có lá mảnh mại, màu xanh đậm, tạo nên một hình ảnh tươi mới và hấp dẫn. Lá xà lách thường có dạng rũ xuống và có các rãnh nhỏ trên bề mặt.', 20000, N'images/product/xa-lach-lolo-xanh-wineco-300g.jpg', N'RL01', N'DC10', N'300G', 1)
INSERT [dbo].[Products] ([productID], [nameProduct], [description], [price], [imageURL], [categoryID], [discountID], [unit], [available]) VALUES (N'SP016', N'Cafe Hòa Tan', N' Cà phê hòa tan 3 trong 1 Nescafé là sản phẩm thế mạnh của thương hiệu Nestlé - một trong những thương hiệu uy tín, nổi tiếng trên thế giới. Từ những hạt cà phê thơm ngon nhất vừa mới thu hoạch, qua quá trình rang xay cầu kì, cẩn thận, tạo ra loại sản phẩm mang hương vị đặc trưng, riêng biệt, hấp dẫn mọi người thưởng thức.', 64000, N'images/product/cafe_hoatan.jpg', N'DU003', N'DC10', N'HỘP', 1)
INSERT [dbo].[Products] ([productID], [nameProduct], [description], [price], [imageURL], [categoryID], [discountID], [unit], [available]) VALUES (N'SP017', N'Thịt Thăn Bò', N' Sản phẩm Thăn thịt bò 300g do VinMart cung cấp được sản xuất và sơ chế theo quy trình khép kín dưới sự giám sát và kiểm tra nghiêm ngặt, đảm bảo vệ sinh an toàn thực phẩm. Thăn bò rất giàu chất sắt có tác dụng bổ sung lượng máu cho cơ thể và phòng tránh cơ thể bị thiếu máu nên đặc biệt thích hợp cho những người có thể chất yếu hoặc trí não đang bị suy giảm.', 180000, N'images/product/thịt_thăn_bò.jpg', N'TH002', NULL, N'0.5KG', 1)
INSERT [dbo].[Products] ([productID], [nameProduct], [description], [price], [imageURL], [categoryID], [discountID], [unit], [available]) VALUES (N'SP018', N'Ba Chỉ Bò', N' Sản phẩm Ba chỉ bò 300g do FF cung cấp được sản xuất và sơ chế theo quy trình khép kín dưới sự giám sát và kiểm tra nghiêm ngặt, đảm bảo vệ sinh an toàn thực phẩm. Thăn bò rất giàu chất sắt có tác dụng bổ sung lượng máu cho cơ thể và phòng tránh cơ thể bị thiếu máu nên đặc biệt thích hợp cho những người có thể chất yếu hoặc trí não đang bị suy giảm.', 150000, N'images/product/ba chỉ bò.jpg', N'TH002', NULL, N'KHAY', 1)
INSERT [dbo].[Products] ([productID], [nameProduct], [description], [price], [imageURL], [categoryID], [discountID], [unit], [available]) VALUES (N'SP020', N'Trà Hoa Atiso', N'Trà hoa Atisô túi lọc được chế biến trên dây chuyền hiện đại từ những cây hoa atiso tự nhiên được trồng ở vùng đất Đà Lạt, đảm bảo . Sản phẩm không sử dụng hóa chất bảo quản, không chất phụ gia độc hại nên rất an toàn sức khỏe cho người sử dụng.', 120000, N'images/product/tra_hoa_Atiso.jpg', N'DU005', NULL, N'GÓI', 1)
INSERT [dbo].[Products] ([productID], [nameProduct], [description], [price], [imageURL], [categoryID], [discountID], [unit], [available]) VALUES (N'SP021', N'Bia Heineken', N'Bia Heineken lon 330ml có quy trình sản xuất, từ lựa chọn nguyên liệu, chế biến, đóng gói đều được làm trên dây chuyền công nghệ hiện đại, khép kín, đảm bảo việc ra đời sản phẩm có chất lượng tốt, độ an toàn cao. Bia được đóng gói đẹp mắt, thích hợp để để tặng, hay sử dụng cho tiệc ngoài trời, du lịch, dã ngoại.
Nồng độ: 5%', 450000, N'images/product/Bia Heineken.jpg', N'DU004', NULL, N'THÙNG 24', 1)
INSERT [dbo].[Products] ([productID], [nameProduct], [description], [price], [imageURL], [categoryID], [discountID], [unit], [available]) VALUES (N'SP022', N'Táo Đỏ Mỹ', N'Táo có nhiều công dụng đối với sức khỏe con người, cả về giá trị dinh dưỡng lẫn công dụng phòng, trị bệnh. Táo có thành phần dinh dưỡng rất phong phú, đặc biệt là các loại vi chất, sinh tố và axit hoa quả. Trong táo chứa nhiều chất pectin, một chất xơ hòa tan làm giảm cholesterol và chất chống oxy hóa, ngăn ngừa bệnh tim cùng các loại vitamin A, C, E. ', 90000, N'images/product/Táo đỏ mỹ.jpg', N'TC001', NULL, N'1KG', 1)
INSERT [dbo].[Products] ([productID], [nameProduct], [description], [price], [imageURL], [categoryID], [discountID], [unit], [available]) VALUES (N'SP023', N'Strongbow Táo', N' Nước táo lên men Strongbow chai 330ml là loại thức uống có nguồn gốc từ châu Âu và đã phổ biến toàn cầu với cách thức chế biến đầy ấn tượng từ quá trình lên men táo tự nhiên, mang đến chất men thuần khiết và hài hòa.', 430000, N'images/product/strongbow.jpg', N'DU004', NULL, N'THÙNG 24', 1)
GO
ALTER TABLE [dbo].[Categories]  WITH CHECK ADD FOREIGN KEY([parentCategoryID])
REFERENCES [dbo].[ParentCategories] ([parentCategoryID])
GO
ALTER TABLE [dbo].[OrderItems]  WITH CHECK ADD FOREIGN KEY([orderID])
REFERENCES [dbo].[Orders] ([orderID])
GO
ALTER TABLE [dbo].[OrderItems]  WITH CHECK ADD FOREIGN KEY([productID])
REFERENCES [dbo].[Products] ([productID])
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([customerID])
REFERENCES [dbo].[Customers] ([customerID])
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD FOREIGN KEY([discountID])
REFERENCES [dbo].[Discounts] ([discountID])
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Product] FOREIGN KEY([categoryID])
REFERENCES [dbo].[Categories] ([categoryID])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Product]
GO
