   M S B A M L   `   `   `  ����G  Cassignment_1, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null+clr-namespace:assignment_1assignment_1  5   	       assignment_1.MainWindow   5   	   W SPresentationCore, Version=7.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=7.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=7.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   ,localclr-namespace:assignment_1     5   	     � Title$  Spotify Freemium��5   	   $	��450��6"   $	��800��6/    J� CommandBindings 5      )  #System.Windows.Input.CommandBinding  5   
   -   5           Command$ ApplicationCommands.Open��5      5        5   
   -   5        $
 Play��5      5        5   
   -   5        $ Pause��5      5        5   
   -   5        $
 Stop��5      5       � 	Resources 5       �� 
TargetType �� Property �� Value �� 	Resources��%  '��       �� 5   
   " ��6   .�5      ��  � ��$ 10q�6(   �� 5        � ��$ 51��6'   �� 5!       � ��$ 41��6(    5"      ���� 5#      '��       " ��6   .�5$      ��  �@��CornerRadius$ 10��65   5%      5&      5'      5(      .��5-      �  � RowDefinitions 5/   
   �� 50      $��6* �6   �� 51      	 � ColumnDefinitions	 53   
   �� 54      $
��131* �6   �� 55      $
��669* �6   ��58   
   �� 59      .��5:      � � 5;      
 � Offset$
 -1Q�6#    � Color$
 Gray��6/   6>   � 5<      $
 1Q�6#   $ Black��6.   6>   5=      5>      .+�5B   
   �� -   5         ��Name$ 	mainStack��5B      $��2��6(   $��2��6=   .+�5D      o� -   5         o�Name$ topBar��5D      .@�5E      m� -   5         m�Name$ 
topBarFile��5E      $
��File��6/   .@�5F      m� -   5        $ openMp3��5F      $
��Open��60    m� Command$ ApplicationCommands.Open��6>   m� 5G      -	   5        $ 
tagCurrent��5G      $��Tag File��63      assignment_1.MainWindow   EditTagsCommand# Z 6E   5H      m� 5I      -
   5        $ 
topBarEdit��5I      $
��Edit��6/   .@�5J      m� -   5        $ editTags��5J      $��	Edit Tags��61   # Z 6D   5K      m� 5L      -   5        $ topBarMedia��5L      $��Media��60   .@�5M      m� -   5        $
 play��5M      $
 Play��6.   m� 5N      -   5        $ Pause��5N      $ Pause��6.   m� 5O      -   5        $
 Stop��5O      $
 Stop��6.   5P      5Q      �� 5T      -   5        $ featurePanel��5T   0    �� Orientation$ Vertical=�6   $	��416��6F   $	��123��6S   $
��Left=�6_    5U      ��%  '��       �� 5V      " ��6   .�5W      ��  � ��$	 100��63   �� 5X       � ��$	 100��62   �� 5Y       � ��$ 	0,20, 0,5q�63    5Z      ���� 5[      '��       " ��6$   .�5\   "   ��  �@��CornerRadius$ 15��6A   5]      5^      5_      5`      .+�5b      �� -   5         ��Name$ openFileBtn��5b      $��ApplicationCommands.Open��6.   .��5c      �� $��./images/open_file.png��6   $
��Fill=�6<   5d      �� 5e      -   5        $ songInfoBtn��5e         SongInfoCommand#��Z 6.   .��5f      �� $��./images/musicnote.png��6   $
��Fill=�6<   $��2q�6K   5g      �� 5h      -   5        $ 
editTagBtn��5h      #��Z 6-   .��5i      �� $��./images/edit.png��6   $
��Fill=�67   $��2q�6F   5j      5k      5l         assignment_1.SongInfo  5o   
   -   5          Name$ songInfo��5o      $��0��6+   $��
0,116,10,5q�68   $��1��6L      assignment_1.TagEditor  5p   
   -   5          Name$ 	tagEditor��5p      $��1��6-   $
��Left=�6=   $��Center=�6X   $	��298��6s   $	��669��6�   $y�	Collapsed=�6�   ]� 5s   
   -   5         ]�Name$ mediaControls��5s      $��1��6+   $��1��68   .+�5t      r� -   5         r�Name$ mediaPlayer��5t       r� LoadedBehavior$ Manual=�60    r� UnloadedBehavior$ Manual=�6H    r� Stretch$
 Fill=�6b   6�   �� 5u      -   5        $ 
playButton��5u      $
��Play��6)   $
��Left=�68   .��5v      �� $��./images/media-play.png��6   5w      �� 5x      -   5        $ pauseButton��5x      $��Pause��6*   .��5y      �� $��./images/pause-icon.png��6   5z      �� 5{      -   5        $ 
stopButton��5{      $
��Stop��6)   .��5|      �� $��./images/stop-icon.png��6   5}      �� 5~      -   5         ��Name$ mediaSlider��5~      $��Right=�6*   $	��336��6A   $��20��6M   6Y   5      5�      5�      